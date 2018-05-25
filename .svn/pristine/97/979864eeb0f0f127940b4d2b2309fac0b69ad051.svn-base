package cn.csbe.web.cms.product.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import cn.csbe.web.cms.auth.bean.UserPassword;
import cn.csbe.web.cms.common.CSBE;
import cn.csbe.web.cms.common.Result;
import cn.csbe.web.cms.common.UploadResult;
import cn.csbe.web.cms.common.UploadUtils;
import cn.csbe.web.cms.common.constantUtils;
import cn.csbe.web.cms.common.bean.Message;
import cn.csbe.web.cms.product.bean.Product;
import cn.csbe.web.cms.product.bean.ProductAttribute;
import cn.csbe.web.cms.product.bean.ProductCategory;
import cn.csbe.web.cms.product.bean.ProductType;
import cn.csbe.web.cms.product.bean.SinglePicture;
import cn.csbe.web.cms.product.bean.SinglePictureDetail;
import cn.csbe.web.cms.product.service.ProductAttributeService;
import cn.csbe.web.cms.product.service.ProductCategoryService;
import cn.csbe.web.cms.product.service.ProductService;
import cn.csbe.web.cms.product.service.ProductTypeService;
/*
 * author sxzhang
 * @ProductController
 */
@Controller
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@Autowired
	private ProductCategoryService productCategoryService;

	@Autowired
	private ProductTypeService productTypeService;
	@Autowired
	private ProductAttributeService productAttributeService;
	
	/**
	 * 跳转到管理页
	 */
	@RequestMapping("toProductList")
	private Object toProduct() {

		return "/product/product";
	}
	/**
	 * 跳转到添加商品页面
	 */
	@RequestMapping("toAddProduct")
	private String addProduct() {

		return "/product/addProduct";
	}
	/*
	 * 根据一级类别id进行二级类别查询
	 * @Param id
	 */
	@RequestMapping("toProductType")
	@ResponseBody
	public ModelAndView selectCategoryByPid(){
		ModelAndView model = new ModelAndView("product/showProductType");
		List<ProductCategory> list = new ArrayList<ProductCategory>();
		List<ProductCategory> list1=null;
		list = productCategoryService.selectProductCategory();
		if(list.size()>0){
			for (ProductCategory productCategory : list) {
				int id = productCategory.getId();
				list1 = productCategoryService.selectCategoryByPid(id);
				productCategory.setChildren(list1);
			}
		}
		
		model.addObject("list", list);
		//model.addObject("list1", list1);
		//查询一级分类  遍历  根据一级类别id 去查询子分类
		return model;
	}
	/*
	 * 查询一级类别信息
	 */
	@RequestMapping("/selectFirstCategory")
	@ResponseBody
	public List<ProductCategory> selectFirstCategory(){
		
		return  productCategoryService.selectProductCategory();
	}
	/**
	 * 根据分类id查询
	 */
	@RequestMapping("/showCategoryById")
	@ResponseBody
	public Map<String,Object> showCategoryById(ProductCategory productCate){
		Map<String,Object> map = new HashMap<String,Object>();
		ProductCategory cate = productCategoryService.showCategoryById(productCate.getId());
		map.put("productCategory", cate);
		return map;
	}
	
	/*
	 * 查询出所有的商品信息进行展示
	 * selectAllProduct
	 * @page 当前页数
	 * @rows 展示的数据的条数
	 * list.toString() 把list类型的数据转换成String类型
	 */
	@RequestMapping(value ="/selectAllProduct",method=RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> selectAllProduct(Product product,Integer page,Integer rows,HttpServletRequest request) throws Exception{
		Map<String,Object> map =new HashMap<String, Object>();
		//模糊查询，根据输入的关键字
		String name=product.getName();
		if(name!=null){
			name = new String(name.getBytes("ISO-8859-1"),"UTF-8");
			map = productService.searchProduct(name,page,rows);
			return map;
		}
		//根据状态进行分类查询
		String type=product.getType();
		if(type==null||type==""||Integer.parseInt(type)==1){
			map = productService.selectAllProduct(page,rows);
			return map;
		}else if(Integer.parseInt(type)==2){//查询在仓库中的商品
			map = productService.selectProductInCk(page,rows);
			return map;
		}else if(Integer.parseInt(type)==3){//查询库存为0的商品
			map = productService.selectProductByquantityNumber(page,rows);
			return map;
		}else if(Integer.parseInt(type)==4){//查询推荐的商品 idRecommend
			map = productService.selectProductByRecommend(page,rows);
			//request.setAttribute("map", map);
			return map;
		}
		return map;
	}
	/*
	 * 添加商品时查询商品分类信息
	 * showCategory
	 */
	@RequestMapping("/showCategory")
	@ResponseBody
	public List<ProductCategory> showCategory(){
		List<ProductCategory> list = new ArrayList<ProductCategory>();
		list = productCategoryService.selectOneCategory();
		return list;
	}
	/*
	 * 展示商品类目信息
	 */
	@RequestMapping("/showType")
	@ResponseBody
	public List<ProductType> showType(){
		List<ProductType> list = new ArrayList<ProductType>();
		list = productTypeService.selectAllType();
		return list;
	}
	/*
	 * 添加商品数据 
	 * @Product
	 * @fileName  商品图片
	 * @fileNamePro 商品详情图片 
	 * @productAttribute 商品参数 ProductAttribute productAttribute,
	 */
	@RequestMapping("/addProduct")
	@ResponseBody
	public boolean addProduct(@RequestParam("fileName")CommonsMultipartFile[] fileName,@RequestParam("fileNamePro")CommonsMultipartFile[] fileNamePro,
			ProductAttribute productAttribute,Product product,String[] attrName,String[] attrValue,HttpServletRequest request){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		List<Object> list = new ArrayList<Object>();
		Map<String,Object> map = new LinkedHashMap<String,Object>();
		SinglePicture sp = null;//保存图片路径的对象
		SinglePictureDetail detail = null;
		//得到文件上传目录
		//String realPath ="http://60.205.152.224:8091/buddha-img/images/product";//服务器地址 
		String realPath = request.getSession().getServletContext().getRealPath("/").replace("buddha-bms", "buddha-img"); // 获取本地存储路径 
		//String realPath ="E:/Files/apache-tomcat-7.0.75/webapps/buddha-img/product";
		File file = new File(realPath);
		if(!file.exists() && !file.isDirectory()){
			file.mkdir();
		}
		for (int i = 0; i < fileName.length; i++) {
			//System.out.println(fileName[i].getOriginalFilename());
			//获取上传的文件的名字
			if(!fileName[i].isEmpty()){//如果文件名字不为空  进行数据的写入
				String filename = fileName[i].getOriginalFilename();
				String extName = filename.substring(filename.lastIndexOf('.')+1);
				String prefix = constantUtils.get_id();
				//新文件名称
				String newFileName = prefix +'.'+ extName;
				String path = realPath+"/images/product/";
				File dir = new File(path);
				if(!dir.exists())
				{
					dir.mkdirs();
				}
				File file1 = new File(dir,newFileName); //把图片保存在dir路径中
				try {
					fileName[i].getFileItem().write(file1);
	            } catch (Exception e) {  
	                e.printStackTrace();  
	            }
				//对象赋值
				String finalName = "product/"+newFileName;
				sp = new SinglePicture();
				sp.setSourceImg(finalName);
				map = new LinkedHashMap<String,Object>();
				map.put("sourceImg",sp.getSourceImg());
			}
			list.add(map);
		}
		List list1 = new ArrayList();
		//商品详情图片
		for (int i = 0; i < fileNamePro.length; i++) {
			//获取上传的文件的名字
			if(!fileNamePro[i].isEmpty()){//如果文件名字不为空  进行数据的写入
				String filename = fileNamePro[i].getOriginalFilename();
				String extName = filename.substring(filename.lastIndexOf('.')+1);
				String prefix = constantUtils.get_id();
				//新文件名称
				String newFileName = prefix +'.'+ extName;
				String path = realPath+"/images/product/";
				File dir = new File(path);
				if(!dir.exists())
				{
					dir.mkdirs();
				}
				File file1 = new File(dir,newFileName); //把图片保存在dir路径中
				try {
					fileNamePro[i].getFileItem().write(file1);
	            } catch (Exception e) {  
	                e.printStackTrace();  
	            }
				String finalName = "product/"+newFileName;
				detail = new SinglePictureDetail();
				map = new LinkedHashMap<String,Object>();
				detail.setSourceImg(finalName);
				map.put("sourceImg",detail.getSourceImg());
			}
			list1.add(map);
		}
		product.setCreateDate(sdf.format(new Date()));
		product.setProductImgJson(JSONArray.fromObject(list).toString());
		product.setProductDetailImgJson(JSONArray.fromObject(list1).toString());
		//规格参数
		boolean isAdd = productService.addProduct(product);
		List list2 = new ArrayList();
		String[] attrNames = attrName;
		String[] attrValues = attrValue;
		//查询当前商品id
		if(isAdd){
			int productId = productService.selectNewId();
			productAttribute.setProductId(productId);
			String value="未定义";
			for (int i = 0; i < attrNames.length; i++) {
				productAttribute.setCreateDate(sdf.format(new Date()));
				productAttribute.setAttrName(attrName[i]);
				if(attrValue.length>=i){//添加判断 防止参数值为空时出现空指针异常
					productAttribute.setAttrValue(attrValue[i]);
				}else{
					productAttribute.setAttrValue(value);
				}
				productAttributeService.addAttribute(productAttribute);
			}
			return true;
		}
		return false;
	}
	/* 批量删除商品
	 * deleteProduct
	 * @Param ids
	 */
	@RequestMapping("/deleteProduct")
	@ResponseBody
	public Map deleteProduct(int[] id){
		System.out.println(id+"++++++");
		Map map = new HashMap();
		boolean idDelete =productService.delete(id);
		map.put("idDelete", idDelete);
		return map;
	}
	/*
	 * 批量下架商品
	 * @Param ids
	 */
	@RequestMapping("/updatePro")
	@ResponseBody
	public Map updatePro(int[] id){
		System.out.println(id+"++++++");
		Map map = new HashMap();
		boolean updatePro =productService.updatePro(id);
		map.put("updatePro", updatePro);
		return map;
	}
	
	/*
	 * 批量上架商品
	 * @Param ids
	 */
	@RequestMapping("/shelvesProduct")
	@ResponseBody
	public Map shelvesProduct(int[] id){
		Map map = new HashMap();
		boolean updatePro =productService.shelvesProduct(id);
		map.put("updatePro", updatePro);
		return map;
	}
	/*
	 * 批量取消推荐商品
	 * @Param ids
	 */
	@RequestMapping("/updateProByRecommend")
	@ResponseBody
	public Map updateProByRecommend(int[] id){
		Map map = new HashMap();
		boolean updatePro =productService.updateProByRecommend(id);
		map.put("updatePro", updatePro);
		return map;
	}
	
	/*
	 * 查询页面加载所需数据
	 * @Param id
	 */
	@RequestMapping("/toEditProduct")
	@ResponseBody
	public ModelAndView toEditProduct(Integer id){
		Product product = productService.selectById(id);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("product", product);//商品对象
		modelAndView.setViewName("product/editProduct");
		return  modelAndView;
	}
	/*
	 * 请求查询参数信息 根据商品id
	 * @parameter id
	 */
	@RequestMapping("/selectProductAttribute")
	@ResponseBody
	private List<ProductAttribute> selectProductAttribute(Integer id){
		List<ProductAttribute> list = productAttributeService.selectByProductId(id);
		return list;
	}
	/*
	 * 请求商品图片
	 */
	@RequestMapping("/selectImgJson")
	@ResponseBody
	public List selectImgJson(Integer id){
		Product product = productService.selectById(id);
		String str = product.getProductImgJson();
		JSONArray array=JSONArray.fromObject(str);
		List<SinglePicture> list=JSONArray.toList(array, SinglePicture.class);
		List list1= new ArrayList();//存储查询出来的图片数据
		if(list.size()>0){
			for(SinglePicture s:list){
				list1.add(s);
				//System.out.println(s);
			}
		}
		
		return list1;		
	}
	/*
	 * 请求商品详情图片
	 */
	@RequestMapping("/selectDatailImgJson")
	@ResponseBody
	public List selectDatailImgJson(Integer id){
		Product product = productService.selectById(id);
		String str = product.getProductDetailImgJson();
		System.out.println(str);
		JSONArray array=JSONArray.fromObject(str);
		List<SinglePictureDetail> list=JSONArray.toList(array, SinglePictureDetail.class);
		List list1= new ArrayList();//存储查询出来的图片数据
		if(list.size()>0){
			for(SinglePictureDetail s:list){
				list1.add(s);
			}
		}
		return list1;		
	}
	/*
	 * 修改商品
	 */
	@RequestMapping("/updateProduct")
	@ResponseBody
	public boolean updateProduct(@RequestParam("fileName")CommonsMultipartFile[] fileName,@RequestParam("fileNamePro")CommonsMultipartFile[] fileNamePro,
			ProductAttribute productAttribute,Product product,String[] attrName,String[] attrValue,HttpServletRequest request){
		List<Object> list = new ArrayList<Object>();
		Map<String,Object> map = new HashMap<String,Object>();
		SinglePicture sp = null;//保存图片路径的对象
		SinglePictureDetail detail = null;
		if(product.getTitleImg() ==null || product.getTitleImg() ==""){
			Product pro = productService.selectById(product.getId());
			product.setTitleImg(pro.getTitleImg());
		}
		//String realPath ="http://www.datec.cn/imgService/product";//服务器地址 
		//String realPath =request.getRealPath("/image/imgProduct"); //本地地址
		String realPath = request.getSession().getServletContext().getRealPath("/").replace("buddha-bms", "buddha-img"); // 获取本地存储路径 
		File file = new File(realPath);
		if(!file.exists() && !file.isDirectory()){
			file.mkdir();
		}
		for (int i = 0; i < fileName.length; i++) {
			//System.out.println(fileName[i].getOriginalFilename());
			//获取上传的文件的名字
			if(!fileName[i].isEmpty()){//如果文件名字不为空  进行数据的写入
				String filename = fileName[i].getOriginalFilename();
				String extName = filename.substring(filename.lastIndexOf('.')+1);
				String prefix = constantUtils.get_id();
				//新文件名称
				String newFileName = prefix +'.'+ extName;
				String path = realPath+"/images/product/";
				File dir = new File(path);
				if(!dir.exists())
				{
					dir.mkdirs();
				}
				File file1 = new File(dir,newFileName); //把图片保存在dir路径中
				try {
					fileName[i].getFileItem().write(file1);
	            } catch (Exception e) {  
	                e.printStackTrace();  
	            }
				//对象赋值
				String finalName = "/product/"+newFileName;
				sp = new SinglePicture();
				sp.setSourceImg(finalName);
				map =new LinkedHashMap<String,Object>();
				map.put("sourceImg",sp.getSourceImg());
			}
			list.add(map);
		}
		List list1 = new ArrayList();
		//商品详情图片
		for (int i = 0; i < fileNamePro.length; i++) {
			//获取上传的文件的名字
			if(!fileNamePro[i].isEmpty()){//如果文件名字不为空  进行数据的写入
				String filename = fileNamePro[i].getOriginalFilename();
				String extName = filename.substring(filename.lastIndexOf('.')+1);
				String prefix = constantUtils.get_id();
				//新文件名称
				String newFileName = prefix +'.'+ extName;
				String path = realPath+"/images/product/";
				File dir = new File(path);
				if(!dir.exists())
				{
					dir.mkdirs();
				}
				File file1 = new File(dir,newFileName); //把图片保存在dir路径中
				try {
					fileNamePro[i].getFileItem().write(file1);
	            } catch (Exception e) {  
	                e.printStackTrace();  
	            }
				String finalName = "/product/"+newFileName;
				detail = new SinglePictureDetail();
				detail.setSourceImg(finalName);
				map = new LinkedHashMap<String,Object>();
				map.put("sourceImg",detail.getSourceImg());
			}
			list1.add(map);
		}
		product.setProductImgJson(JSONArray.fromObject(list).toString());
		product.setProductDetailImgJson(JSONArray.fromObject(list1).toString());
		System.out.println(product.getProductImgJson()+""+product.getProductDetailImgJson());
		//规格参数
		boolean isUpdate = productService.updateProduct(product);
		
		List list2 = new ArrayList();
		String[] attrNames = attrName;
		String[] attrValues = attrValue;
		//查询当前商品id
		if(isUpdate){//根据商品id查询出参数集合，如果集合长度大于0 把对应这个商品id的参数都给删除了，然后重新添加参数
			productAttribute.setProductId(product.getId());
			productAttributeService.deleteAtt(product.getId());
			for (int i = 0; i < attrNames.length; i++) {
				productAttribute.setAttrName(attrName[i]);
				productAttribute.setAttrValue(attrValue[i]);
				productAttributeService.addAttribute(productAttribute);
			}
			return true;
		}
		return false;
	}
	
	/**
	 * 图片上传
	 */
	@RequestMapping(value = "upload/pictrue", method = RequestMethod.POST)
	@ResponseBody
	private Object uploadfile(@RequestParam("upfile") CommonsMultipartFile mFile, HttpServletRequest request,
			HttpServletResponse response, UserPassword userPassword) throws Exception {

		UploadResult uploadResult = UploadUtils.upload(request, mFile,constantUtils.PRO_TITLE_IMG);

		if (uploadResult == null || uploadResult.getStatus() != CSBE.OK) {
			return new Message(false, "不合法的文件类型");
		}

		return CSBE.encryption(new Result(CSBE.OK, "上传成功", uploadResult.getValue()));

	}
	
	
	
	
	
	
	

}
