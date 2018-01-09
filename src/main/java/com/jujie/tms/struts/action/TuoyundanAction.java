package com.jujie.tms.struts.action;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jujie.tms.model.service.TuoyundanService;
import com.jujie.tms.model.utils.BaseActionSupper;
import com.jujie.tms.model.utils.Page;
import com.jujie.tms.struts.bean.Kehu;
import com.jujie.tms.struts.bean.Tuoyundan;

public class TuoyundanAction extends BaseActionSupper {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String s_token;
	private Page page;
	private Tuoyundan tuoyundan;
	private List<Tuoyundan> tuoyundanList;
	private List<Kehu> kehuList;
	private Kehu kehu;

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public Tuoyundan getTuoyundan() {
		return tuoyundan;
	}

	public void setTuoyundan(Tuoyundan tuoyundan) {
		this.tuoyundan = tuoyundan;
	}

	public List<Tuoyundan> getTuoyundanList() {
		return tuoyundanList;
	}

	public void setTuoyundanList(List<Tuoyundan> tuoyundanList) {
		this.tuoyundanList = tuoyundanList;
	}

	public String getS_token() {
		return s_token;
	}

	public void setS_token(String s_token) {
		this.s_token = s_token;
	}

	public List<Kehu> getKehuList() {
		return kehuList;
	}

	public void setKehuList(List<Kehu> kehuList) {
		this.kehuList = kehuList;
	}

	public Kehu getKehu() {
		return kehu;
	}

	public void setKehu(Kehu kehu) {
		this.kehu = kehu;
	}

	
	
	// 查询
	public String queryTuoyundanList() throws Exception {
		if (page == null) {
			page = new Page(1);
		}
		// 产生日期
		SimpleDateFormat formatBtime = new java.text.SimpleDateFormat("yyyy-MM-dd 00:00");
		SimpleDateFormat formatEtime = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm");
		Calendar cal = Calendar.getInstance();// 取当前日期。
		cal.add(Calendar.MINUTE, 1);//加1分钟
		String tag = request.getParameter("tag");
		String btime = "";
		String etime = "";
		if ("list".equals(tag)) {
			btime = formatBtime.format(cal.getTime());
			etime = formatEtime.format(cal.getTime());
			request.setAttribute("btime", btime);
			request.setAttribute("etime", etime);
		} else {
			btime = request.getParameter("btime");
			etime = request.getParameter("etime");
			request.setAttribute("btime", btime);
			request.setAttribute("etime", etime);
		}

		// 订单状态
		// tuoyundan = new Tuoyundan();
		// tuoyundan.setState(0);

		// 列表条件查询
		TuoyundanService tuoyundanService = (TuoyundanService) this.getService("tuoyundanService");

		tuoyundanList = tuoyundanService.queryTuoyundanList(tuoyundan, page, btime, etime);

		// 计算单据合计,费用合计,代收货款合计,总合计,件数合计,实收运费,手续费合计,物流券合计
		if (null != tuoyundanList && !"".equals(tuoyundanList) && tuoyundanList.size() > 0) {
			int djhj = 0; // 单据合计
			int yfhj = 0;// 运费合计
			int dshj = 0;// 代收货款合计
			int sxhj = 0;// 手续费合计
			int qthj = 0;// 其他费用合计
			int fzhj = 0;// 费用总合计
			int jshj = 0;// 件数合计
			Map<String, Integer> contMap = new HashMap<String, Integer>();
			for (Tuoyundan tuoyundan : tuoyundanList) {
				yfhj = yfhj + Integer.valueOf(tuoyundan.getYunfei());
				dshj = dshj + Integer.valueOf(tuoyundan.getDshk());
				sxhj = sxhj + Integer.valueOf(tuoyundan.getSxf());
				qthj = qthj + Integer.valueOf(tuoyundan.getQtfy());
				jshj = jshj + Integer.valueOf(tuoyundan.getJianshu());
			}
			djhj = tuoyundanList.size();
			fzhj = yfhj + dshj + sxhj + qthj;

			contMap.put("djhj", djhj);
			contMap.put("yfhj", yfhj);
			contMap.put("dshj", dshj);
			contMap.put("sxhj", sxhj);
			contMap.put("qthj", qthj);
			contMap.put("fzhj", fzhj);
			contMap.put("jshj", jshj);

			request.setAttribute("contMap", contMap);
		}

		return "list";
	}

	
	
	// 到新增或修改页面
	public String findTuoyundanForModify() throws Exception {
		TuoyundanService tuoyundanService = (TuoyundanService) this.getService("tuoyundanService");
		String modify = request.getParameter("modify");
		if (null != modify && "save".equals(modify)) {
			// 生产日期
			SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Calendar cal = Calendar.getInstance();// 取当前日期。
			tuoyundan = new Tuoyundan();
			tuoyundan.setTydate(sdf.format(cal.getTime()));

			// 生成单号
			SimpleDateFormat format1 = new java.text.SimpleDateFormat("yyMMddHHmmss");
			String tydh = format1.format(cal.getTime());
			int x = (int) (Math.random() * 100);
			tuoyundan.setTydh(tydh + x);
		} else if (null != modify && "update".equals(modify)) {
			String tyid = request.getParameter("tyid");
			if (null != tyid && !"".equals(tyid)) {
				tuoyundan = tuoyundanService.findTuoyundanByID(Integer.valueOf(tyid));
			}
		}
		return "modify";
	}
	
	
	
	
	// 新增或修改
	public String modifyTuoyundan() throws Exception {
		TuoyundanService tuoyundanService = (TuoyundanService) this.getService("tuoyundanService");
		if (null != tuoyundan) {
			Integer pid = tuoyundanService.modifyTuoyundan(tuoyundan);
			if (null != pid) {
				String ppid = String.valueOf(pid);
				request.getSession().setAttribute("ppid", ppid);
			}
		}
		return showTuoyundan();
	}
	

	// 打印
	public String showTuoyundan() throws Exception {
		TuoyundanService tuoyundanService = (TuoyundanService) this.getService("tuoyundanService");
		String pidd = (String) request.getSession().getAttribute("ppid");
		if (null != pidd && !"".equals(pidd)) {
			tuoyundan = tuoyundanService.findTuoyundanByID(Integer.valueOf(pidd));
		}
		request.getSession().removeAttribute(pidd);
		return "show";
	}

	// 查看
	public String showTuoyundanByID() throws Exception {
		TuoyundanService tuoyundanService = (TuoyundanService) this.getService("tuoyundanService");
		String tyid = request.getParameter("tyid");
		if (null != tyid && !"".equals(tyid)) {
			tuoyundan = tuoyundanService.findTuoyundanByID(Integer.valueOf(tyid));
		}
		return "show";
	}

	// 撤销
	public String deleteTuoyundanByID() throws Exception {
		TuoyundanService tuoyundanService = (TuoyundanService) this.getService("tuoyundanService");
		String tyid = request.getParameter("tyid");
		if (null != tyid && !"".equals(tyid)) {
			tuoyundanService.deleteTuoyundanByID(Integer.valueOf(tyid));
		}
		return this.queryTuoyundanList();
	}
	
	
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	//统计--运单查询
	public String queryTuoyundanForCount() throws Exception {
		String type = request.getParameter("type");
		TuoyundanService tuoyundanService = (TuoyundanService) this.getService("tuoyundanService");
		if("page".equals(type)&&null!=type){ //直接到运单统计LIST 页面 但不查询
			return "yundan";
		}
		
		String btime = request.getParameter("btime");
		String etime = request.getParameter("etime"); 
		String danshu = request.getParameter("danshu"); 
		request.setAttribute("btime", btime);
		request.setAttribute("etime", etime);
		request.setAttribute("danshu", danshu);
		
		tuoyundanList = tuoyundanService.queryTuoyundanForCount(btime, etime, danshu, tuoyundan);
		// 计算单据合计,费用合计,代收货款合计,总合计,件数合计,实收运费,手续费合计,物流券合计
				if (null != tuoyundanList && !"".equals(tuoyundanList) && tuoyundanList.size() > 0) {
					int djhj = 0; // 单据合计
					int yfhj = 0;// 运费合计
					int dshj = 0;// 代收货款合计
					int sxhj = 0;// 手续费合计
					int qthj = 0;// 其他费用合计
					int fzhj = 0;// 费用总合计
					int jshj = 0;// 件数合计
					Map<String, Integer> contMap = new HashMap<String, Integer>();
					for (Tuoyundan tuoyundan : tuoyundanList) {
						yfhj = yfhj + Integer.valueOf(tuoyundan.getYunfei());
						dshj = dshj + Integer.valueOf(tuoyundan.getDshk());
						sxhj = sxhj + Integer.valueOf(tuoyundan.getSxf());
						qthj = qthj + Integer.valueOf(tuoyundan.getQtfy());
						jshj = jshj + Integer.valueOf(tuoyundan.getJianshu());
					}
					djhj = tuoyundanList.size();
					fzhj = yfhj + dshj + sxhj + qthj;

					contMap.put("djhj", djhj);
					contMap.put("yfhj", yfhj);
					contMap.put("dshj", dshj);
					contMap.put("sxhj", sxhj);
					contMap.put("qthj", qthj);
					contMap.put("fzhj", fzhj);
					contMap.put("jshj", jshj);

					request.setAttribute("contMap", contMap);
				}
		
		return "yundan";
	}
}
