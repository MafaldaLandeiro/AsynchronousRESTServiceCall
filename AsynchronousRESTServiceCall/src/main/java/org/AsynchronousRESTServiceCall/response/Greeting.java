package org.AsynchronousRESTServiceCall.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Greeting {
	private String date;
	
	private String content;

	/**
	 * 
	 */
	public Greeting() {
		super();
	}

	/**
	 * @param date
	 * @param content
	 */
	public Greeting(String date, String content) {
		super();
		this.date = date;
		this.content = content;
	}

	/**
	 * @return the date
	 */
	public String getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}

	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Greeting [date=" + date + ", content=" + content + "]";
	}
}
