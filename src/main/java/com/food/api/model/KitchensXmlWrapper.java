package com.food.api.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.food.domain.model.Kitchen;

import lombok.Data;
import lombok.NonNull;

@JacksonXmlRootElement(localName = "kitchens")
@Data
public class KitchensXmlWrapper {

	@JsonProperty("kitchen")
	@JacksonXmlElementWrapper(useWrapping = false)
	@NonNull
	private List<Kitchen> kitchens;
	
}
