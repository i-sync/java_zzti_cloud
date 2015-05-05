package com.zzti.utils;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class PagingTag extends TagSupport {

	public enum PageType {
		English("First", "Prev", "Next", "Last"), Chinese("��ҳ", "��һҳ", "��һҳ",
				"ĩҳ"), Sign("<<", "<", ">", ">>");

		private String first;
		private String prev;
		private String next;
		private String last;

		public String getFirst() {
			return first;
		}

		public String getPrev() {
			return prev;
		}

		public String getNext() {
			return next;
		}

		public String getLast() {
			return last;
		}

		PageType(String first, String prev, String next, String last) {
			this.first = first;
			this.prev = prev;
			this.next = next;
			this.last = last;
		}
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 7073567267921619784L;

	private int pageIndex;
	private int pageMax;
	private String url;

	private PageType type = PageType.English;

	public int getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	public int getPageMax() {
		return pageMax;
	}

	public void setPageMax(int pageMax) {
		if (pageMax == 0)
			this.pageMax = this.pageIndex;
		else
			this.pageMax = pageMax;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url.contains("?") ? url + "&" : url + "?";
	}

	public PagingTag() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int doStartTag() throws JspException {
		String str = "";
		if (pageIndex == 1) {
<<<<<<< HEAD
			str += "首页 上一页 ";
		} else {
			str += " <a href='" + url + "pageIndex=1'>首页</a> " + "<a href='"
					+ url + "pageIndex=" + (pageIndex - 1) + "'>上一页</a> ";
=======
			str += String.format("%1$s %2$s", type.getFirst(), type.getPrev());
		} else {
			// str += " <a href='" + url + "pageIndex=1'>First</a> " +
			// "<a href='"
			// + url + "pageIndex=" + (pageIndex - 1) + "'>Prev</a> ";
			str += String
					.format(" <a href='%1$spageIndex=1'>%2$s</a> <a href='%1$spageIndex=%3$s'>%4$s</a> ",
							url, type.getFirst(), pageIndex - 1, type.getPrev());
>>>>>>> f168441e13d90241f3f0ba83388b887e152f7f8d
		}
		if (pageIndex / 6 < 1.0 || pageMax < 10) {
			for (int i = 1; i <= 9; i++) {
				if (i <= pageMax) {
					if (pageIndex != i) {
						// str += "<a href='" + url + "pageIndex=" + i + "'>[" +
						// i
						// + "]</a> ";
						str += String.format(
								"<a href='%1$spageIndex=%2$s'>[%2$s]</a> ",
								url, i);
					} else {
						str += "  " + i + " ";
					}
				}
			}
		} else if (pageIndex / 6 >= 1.0 && pageMax >= 10) {
			int fri = 0;
			int max = 0;
			if (pageMax - pageIndex > 4) {
				fri = pageIndex - 4;
				max = pageIndex + 4;
			} else {
				fri = pageMax - 8;
				max = pageMax;
			}
			for (int i = fri; i <= max; i++) {
				if (i <= pageMax) {
					if (pageIndex != i) {
						// str += "<a href='" + url + "pageIndex=" + i + "'>[" +
						// i
						// + "]</a> ";
						str += String.format(
								"<a href='%1$spageIndex=%2$s'>[%2$s]</a> ",
								url, i);
					} else {
						str += "  " + i + " ";
					}
				}
			}
		}
		if (pageIndex == pageMax || pageMax < 2) {
<<<<<<< HEAD
			str += "下一页 尾页";
		} else {
			str += "<a href='" + url + "pageIndex=" + (pageIndex + 1)
					+ "'>下一页</a> " + "<a href='" + url + "pageIndex=" + pageMax
					+ "'>尾页</a>";
=======
			str += String.format("%1$s %2$s", type.getNext(), type.getLast());
		} else {
			// str += "<a href='" + url + "pageIndex=" + (pageIndex + 1)
			// + "'>Next</a> " + "<a href='" + url + "pageIndex="
			// + pageMax + "'>Last</a>";
			str += String
					.format("<a href='%1$spageIndex=%2$s'>%3$s</a> <a href='%1$spageIndex=%4$s'>%5$s</a>",
							url, pageIndex + 1, type.getNext(), pageMax,
							type.getLast());
>>>>>>> f168441e13d90241f3f0ba83388b887e152f7f8d
		}
		try {
			if (str != "") {
				pageContext.getOut().write(str);
			}
		} catch (Exception e) {
			throw new JspException(e);
		}
		return EVAL_PAGE;
	}

}
