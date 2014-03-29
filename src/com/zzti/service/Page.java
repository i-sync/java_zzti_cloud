
package com.zzti.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>page complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="page">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="endDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="pageIndex" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="pageSize" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="stratDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="totalCount" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "page", propOrder = {
    "endDate",
    "pageIndex",
    "pageSize",
    "stratDate",
    "totalCount"
})
public class Page {

    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar endDate;
    protected int pageIndex;
    protected int pageSize;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar stratDate;
    protected int totalCount;

    /**
     * 获取endDate属性的值。
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getEndDate() {
        return endDate;
    }

    /**
     * 设置endDate属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setEndDate(XMLGregorianCalendar value) {
        this.endDate = value;
    }

    /**
     * 获取pageIndex属性的值。
     * 
     */
    public int getPageIndex() {
        return pageIndex;
    }

    /**
     * 设置pageIndex属性的值。
     * 
     */
    public void setPageIndex(int value) {
        this.pageIndex = value;
    }

    /**
     * 获取pageSize属性的值。
     * 
     */
    public int getPageSize() {
        return pageSize;
    }

    /**
     * 设置pageSize属性的值。
     * 
     */
    public void setPageSize(int value) {
        this.pageSize = value;
    }

    /**
     * 获取stratDate属性的值。
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getStratDate() {
        return stratDate;
    }

    /**
     * 设置stratDate属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setStratDate(XMLGregorianCalendar value) {
        this.stratDate = value;
    }

    /**
     * 获取totalCount属性的值。
     * 
     */
    public int getTotalCount() {
        return totalCount;
    }

    /**
     * 设置totalCount属性的值。
     * 
     */
    public void setTotalCount(int value) {
        this.totalCount = value;
    }

}
