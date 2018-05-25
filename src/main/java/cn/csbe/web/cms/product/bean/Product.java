package cn.csbe.web.cms.product.bean;

import cn.csbe.web.cms.common.bean.Page;

/*
 * 商品实体类
 * @author sxzhang
 * 提供get/set方法
 */
public class Product extends Page{

	private Integer id;
	private String name;
	private double costPrice;//成本价格
	private double sellPrice;//售价
	private double originalPrice;//商品原价
	private double profitPrice; // 利润
	private double packPrice; // 包装费用
	private double freightPrice;// 运费金额
	private String titleImg;//商品图像
	private String productImgJson;//商品图片集合，Json格式
	private Integer quantityNumber;//库存量
	private Integer saleNumber;//销量
	private String detailPageHtmlPath;//商品详情页静态HTML文件路径
	private Integer isShelves;//状态
	private Integer productTypeId;//商品所属类目id
	private Integer productCategoryId;//商品分类id  
	private Integer userId;//发布人id
	private Integer enableStatus;//可用状态  默认 启用1  停用0
	private String createDate;//创建时间
	private String modifyDate;//修改时间
	private Integer isPacking;//是否包装  默认不包装 0 bao
	private Integer isRecommend;//是否推荐 默认不推荐  单个目录下最多推荐五条数据
	private Integer isFreight;// 是否统一费用
	private String areaAddress;//地址 名称
	private Integer sortList;
	private String type; //用来获取前台传递过来的数据的状态
	private String productDetailImgJson;//商品详情页图片
	private Integer abbotId;//住持id
	private Integer templeId;//寺院id
	private String code;//编码
	
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", costPrice="
				+ costPrice + ", sellPrice=" + sellPrice + ", originalPrice="
				+ originalPrice + ", profitPrice=" + profitPrice
				+ ", packPrice=" + packPrice + ", freightPrice=" + freightPrice
				+ ", titleImg=" + titleImg + ", productImgJson="
				+ productImgJson + ", quantityNumber=" + quantityNumber
				+ ", saleNumber=" + saleNumber + ", detailPageHtmlPath="
				+ detailPageHtmlPath + ", isShelves=" + isShelves
				+ ", productTypeId=" + productTypeId + ", productCategoryId="
				+ productCategoryId + ", userId=" + userId + ", enableStatus="
				+ enableStatus + ", createDate=" + createDate + ", modifyDate="
				+ modifyDate + ", isPacking=" + isPacking + ", isRecommend="
				+ isRecommend + ", isFreight=" + isFreight + ", areaAddress="
				+ areaAddress + ", sortList=" + sortList + ", type=" + type
				+ ", productDetailImgJson=" + productDetailImgJson
				+ ", abbotId=" + abbotId + ", templeId=" + templeId + ", code="
				+ code + "]";
	}

	public Product(Integer id, String name, double costPrice, double sellPrice,
			double originalPrice, double profitPrice, double packPrice,
			double freightPrice, String titleImg, String productImgJson,
			Integer quantityNumber, Integer saleNumber,
			String detailPageHtmlPath, Integer isShelves,
			Integer productTypeId, Integer productCategoryId, Integer userId,
			Integer enableStatus, String createDate, String modifyDate,
			Integer isPacking, Integer isRecommend, Integer isFreight,
			String areaAddress, Integer sortList, String type,
			String productDetailImgJson, Integer abbotId, Integer templeId,
			String code) {
		super();
		this.id = id;
		this.name = name;
		this.costPrice = costPrice;
		this.sellPrice = sellPrice;
		this.originalPrice = originalPrice;
		this.profitPrice = profitPrice;
		this.packPrice = packPrice;
		this.freightPrice = freightPrice;
		this.titleImg = titleImg;
		this.productImgJson = productImgJson;
		this.quantityNumber = quantityNumber;
		this.saleNumber = saleNumber;
		this.detailPageHtmlPath = detailPageHtmlPath;
		this.isShelves = isShelves;
		this.productTypeId = productTypeId;
		this.productCategoryId = productCategoryId;
		this.userId = userId;
		this.enableStatus = enableStatus;
		this.createDate = createDate;
		this.modifyDate = modifyDate;
		this.isPacking = isPacking;
		this.isRecommend = isRecommend;
		this.isFreight = isFreight;
		this.areaAddress = areaAddress;
		this.sortList = sortList;
		this.type = type;
		this.productDetailImgJson = productDetailImgJson;
		this.abbotId = abbotId;
		this.templeId = templeId;
		this.code = code;
	}

	public Integer getAbbotId() {
		return abbotId;
	}

	public void setAbbotId(Integer abbotId) {
		this.abbotId = abbotId;
	}

	public Integer getTempleId() {
		return templeId;
	}

	public void setTempleId(Integer templeId) {
		this.templeId = templeId;
	}

	public String getProductDetailImgJson() {
		return productDetailImgJson;
	}

	public void setProductDetailImgJson(String productDetailImgJson) {
		this.productDetailImgJson = productDetailImgJson;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getCostPrice() {
		return costPrice;
	}
	public void setCostPrice(double costPrice) {
		this.costPrice = costPrice;
	}
	public double getSellPrice() {
		return sellPrice;
	}
	public void setSellPrice(double sellPrice) {
		this.sellPrice = sellPrice;
	}
	public double getOriginalPrice() {
		return originalPrice;
	}
	public void setOriginalPrice(double originalPrice) {
		this.originalPrice = originalPrice;
	}
	public double getProfitPrice() {
		return profitPrice;
	}
	public void setProfitPrice(double profitPrice) {
		this.profitPrice = profitPrice;
	}
	public double getPackPrice() {
		return packPrice;
	}
	public void setPackPrice(double packPrice) {
		this.packPrice = packPrice;
	}
	public String getTitleImg() {
		return titleImg;
	}
	public void setTitleImg(String titleImg) {
		this.titleImg = titleImg;
	}
	public String getProductImgJson() {
		return productImgJson;
	}
	public void setProductImgJson(String productImgJson) {
		this.productImgJson = productImgJson;
	}
	public Integer getQuantityNumber() {
		return quantityNumber;
	}
	public void setQuantityNumber(Integer quantityNumber) {
		this.quantityNumber = quantityNumber;
	}
	public Integer getSaleNumber() {
		return saleNumber;
	}
	public void setSaleNumber(Integer saleNumber) {
		this.saleNumber = saleNumber;
	}
	public String getDetailPageHtmlPath() {
		return detailPageHtmlPath;
	}
	public void setDetailPageHtmlPath(String detailPageHtmlPath) {
		this.detailPageHtmlPath = detailPageHtmlPath;
	}
	public Integer getIsShelves() {
		return isShelves;
	}
	public void setIsShelves(Integer isShelves) {
		this.isShelves = isShelves;
	}
	public Integer getProductTypeId() {
		return productTypeId;
	}
	public void setProductTypeId(Integer productTypeId) {
		this.productTypeId = productTypeId;
	}
	public Integer getProductCategoryId() {
		return productCategoryId;
	}
	public void setProductCategoryId(Integer productCategoryId) {
		this.productCategoryId = productCategoryId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getEnableStatus() {
		return enableStatus;
	}
	public void setEnableStatus(Integer enableStatus) {
		this.enableStatus = enableStatus;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(String modifyDate) {
		this.modifyDate = modifyDate;
	}
	public Integer getIsPacking() {
		return isPacking;
	}
	public void setIsPacking(Integer isPacking) {
		this.isPacking = isPacking;
	}
	public Integer getIsRecommend() {
		return isRecommend;
	}
	public void setIsRecommend(Integer isRecommend) {
		this.isRecommend = isRecommend;
	}
	public Integer getIsFreight() {
		return isFreight;
	}
	public void setIsFreight(Integer isFreight) {
		this.isFreight = isFreight;
	}
	public double getFreightPrice() {
		return freightPrice;
	}
	public void setFreightPrice(double freightPrice) {
		this.freightPrice = freightPrice;
	}
	public String getAreaAddress() {
		return areaAddress;
	}
	public void setAreaAddress(String areaAddress) {
		this.areaAddress = areaAddress;
	}
	public Integer getSortList() {
		return sortList;
	}
	public void setSortList(Integer sortList) {
		this.sortList = sortList;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
}