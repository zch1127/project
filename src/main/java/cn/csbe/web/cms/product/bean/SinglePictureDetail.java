package cn.csbe.web.cms.product.bean;

import java.io.Serializable;

public class SinglePictureDetail implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String sourceImg;//


	public String getSourceImg() {
		return sourceImg;
	}

	public void setSourceImg(String sourceImg) {
		this.sourceImg = sourceImg;
	}

	public SinglePictureDetail(String sourceImg) {
		super();
		this.sourceImg = sourceImg;
	}

	public SinglePictureDetail() {
		super();
		// TODO Auto-generated constructor stub
	}


}
