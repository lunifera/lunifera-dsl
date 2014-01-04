package org.lunifera.dsl.dto.xtext.common;

@SuppressWarnings("serial")
public class CrossReference implements ICrossReferenceInfo {

	private String target;
	private Object id;
	private String number;
	private String description;

	@Override
	public String getTarget() {
		return target;
	}

	@Override
	public Object getId() {
		return id;
	}

	@Override
	public String getNumber() {
		return number;
	}

	@Override
	public String getDescription() {
		return description;
	}

}
