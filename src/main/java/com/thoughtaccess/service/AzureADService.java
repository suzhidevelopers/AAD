package com.thoughtaccess.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.microsoft.graph.auth.confidentialClient.ClientCredentialProvider;
import com.microsoft.graph.auth.enums.NationalCloud;
import com.microsoft.graph.models.extensions.Group;
import com.microsoft.graph.models.extensions.IGraphServiceClient;
import com.microsoft.graph.models.extensions.User;
import com.microsoft.graph.requests.extensions.GraphServiceClient;
import com.microsoft.graph.requests.extensions.IGroupCollectionPage;
import com.microsoft.graph.requests.extensions.IGroupCollectionRequestBuilder;
import com.microsoft.graph.requests.extensions.IUserCollectionPage;
import com.microsoft.graph.requests.extensions.IUserCollectionRequestBuilder;
import com.thoughtaccess.model.Account;
import com.thoughtaccess.model.Entitlement;

@Service
@PropertySource("classpath:AzureAD.properties")
public class AzureADService {

	@Value("${client_id}")
	private String clientId;
	@Value("${scopes}")
	private List<String> scopes;
	@Value("${client_secret}")
	private String clientSecret;
	@Value("${tenant_guid}")
	private String tenantGuid;

	private IGraphServiceClient graphClient;

	private IGraphServiceClient getGraphServiceClient() {
		ClientCredentialProvider authProvider = new ClientCredentialProvider(this.clientId, this.scopes,
				this.clientSecret, this.tenantGuid, NationalCloud.Global);
		return GraphServiceClient.builder().authenticationProvider(authProvider).buildClient();
	}

	public List<Account> getAccounts() {
		if (this.graphClient == null) {
			this.graphClient = getGraphServiceClient();
		}
		IUserCollectionPage users = graphClient.users().buildRequest().top(100).get();
		List<User> userList = new ArrayList<User>();
		while (users != null) {
			userList.addAll(users.getCurrentPage());
			final IUserCollectionRequestBuilder nextPage = users.getNextPage();
			if (nextPage == null) {
				break;
			} else {
				users = nextPage.buildRequest().get();
			}
		}
		return convertToAccounts(userList);
	}

	private List<Account> convertToAccounts(List<User> userList) {
		List<Account> accountList = new ArrayList<Account>();
		if (!CollectionUtils.isEmpty(userList)) {
			for (User user : userList) {
				accountList.add(new Account(user.userPrincipalName, user.mailNickname, null, "1", user.id,
						user.jobTitle, user.department, user.companyName, user.employeeId, user.employeeType,
						StringUtils.collectionToCommaDelimitedString(user.proxyAddresses), null, null, null, null));
			}
		}
		return accountList;
	}

	private List<Entitlement> convertToEntitlements(List<Group> groupList) {
		List<Entitlement> entitlementList = new ArrayList<Entitlement>();
		if (!CollectionUtils.isEmpty(groupList)) {
			for (Group group : groupList) {
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
				simpleDateFormat.setCalendar(group.createdDateTime);
				String createdDateTime = simpleDateFormat.format(group.createdDateTime.getTime());
				entitlementList.add(new Entitlement(group.id, group.displayName, null, "groups", group.description,
						"Azure AD", createdDateTime, null, null, null, null, null, null, null, null, null, null));
			}
		}
		return entitlementList;
	}

	public List<Entitlement> getEntitlements() {
		if (this.graphClient == null) {
			this.graphClient = getGraphServiceClient();
		}
		IGroupCollectionPage groups = graphClient.groups().buildRequest().top(100).get();
		List<Group> groupList = new ArrayList<Group>();
		while (groups != null) {
			groupList.addAll(groups.getCurrentPage());
			final IGroupCollectionRequestBuilder nextPage = groups.getNextPage();
			if (nextPage == null) {
				break;
			} else {
				groups = nextPage.buildRequest().get();
			}
		}
		return convertToEntitlements(groupList);
	}

}