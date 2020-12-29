package com.thoughtaccess.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Entitlement {

	@JsonProperty("name")
	private String name;
	@JsonProperty("display_value")
	private String displayValue;
	@JsonProperty("owner_id")
	private String ownerId;
	@JsonProperty("attribute_name")
	private String attributeName;
	@JsonProperty("description")
	private String description;
	@JsonProperty("application_id")
	private String applicationId;
	@JsonProperty("param1")
	private String param1;
	@JsonProperty("param2")
	private String param2;
	@JsonProperty("param3")
	private String param3;
	@JsonProperty("param4")
	private String param4;
	@JsonProperty("param5")
	private String param5;
	@JsonProperty("param6")
	private String param6;
	@JsonProperty("param7")
	private String param7;
	@JsonProperty("param8")
	private String param8;
	@JsonProperty("param9")
	private String param9;
	@JsonProperty("param10")
	private String param10;
	@JsonProperty("attributes")
	private String attributes;

	public Entitlement() {
		super();
	}

	public Entitlement(String name, String displayValue, String ownerId, String attributeName, String description,
			String applicationId, String param1, String param2, String param3, String param4, String param5,
			String param6, String param7, String param8, String param9, String param10, String attributes) {
		super();
		this.name = name;
		this.displayValue = displayValue;
		this.ownerId = ownerId;
		this.attributeName = attributeName;
		this.description = description;
		this.applicationId = applicationId;
		this.param1 = param1;
		this.param2 = param2;
		this.param3 = param3;
		this.param4 = param4;
		this.param5 = param5;
		this.param6 = param6;
		this.param7 = param7;
		this.param8 = param8;
		this.param9 = param9;
		this.param10 = param10;
		this.attributes = attributes;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDisplayValue() {
		return displayValue;
	}

	public void setDisplayValue(String displayValue) {
		this.displayValue = displayValue;
	}

	public String getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(String ownerId) {
		this.ownerId = ownerId;
	}

	public String getAttributeName() {
		return attributeName;
	}

	public void setAttributeName(String attributeName) {
		this.attributeName = attributeName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(String applicationId) {
		this.applicationId = applicationId;
	}

	public String getParam1() {
		return param1;
	}

	public void setParam1(String param1) {
		this.param1 = param1;
	}

	public String getParam2() {
		return param2;
	}

	public void setParam2(String param2) {
		this.param2 = param2;
	}

	public String getParam3() {
		return param3;
	}

	public void setParam3(String param3) {
		this.param3 = param3;
	}

	public String getParam4() {
		return param4;
	}

	public void setParam4(String param4) {
		this.param4 = param4;
	}

	public String getParam5() {
		return param5;
	}

	public void setParam5(String param5) {
		this.param5 = param5;
	}

	public String getParam6() {
		return param6;
	}

	public void setParam6(String param6) {
		this.param6 = param6;
	}

	public String getParam7() {
		return param7;
	}

	public void setParam7(String param7) {
		this.param7 = param7;
	}

	public String getParam8() {
		return param8;
	}

	public void setParam8(String param8) {
		this.param8 = param8;
	}

	public String getParam9() {
		return param9;
	}

	public void setParam9(String param9) {
		this.param9 = param9;
	}

	public String getParam10() {
		return param10;
	}

	public void setParam10(String param10) {
		this.param10 = param10;
	}

	public String getAttributes() {
		return attributes;
	}

	public void setAttributes(String attributes) {
		this.attributes = attributes;
	}

	@Override
	public String toString() {
		return "Entitlement [name=" + name + ", displayValue=" + displayValue + ", ownerId=" + ownerId
				+ ", attributeName=" + attributeName + ", description=" + description + ", applicationId="
				+ applicationId + ", param1=" + param1 + ", param2=" + param2 + ", param3=" + param3 + ", param4="
				+ param4 + ", param5=" + param5 + ", param6=" + param6 + ", param7=" + param7 + ", param8=" + param8
				+ ", param9=" + param9 + ", param10=" + param10 + ", attributes=" + attributes + "]";
	}

}