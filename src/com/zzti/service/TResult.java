
package com.zzti.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>tResult complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="tResult">
 *   &lt;complexContent>
 *     &lt;extension base="{http://service.zzti.com/}result">
 *       &lt;sequence>
 *         &lt;element name="t" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tResult", propOrder = {
    "t"
})
public class TResult<T>
    extends Result
{

    protected T t;

    /**
     * 获取t属性的值。
     * 
     * @return
     *     possible object is
     *     {@link T }
     *     
     */
    public T getT() {
        return t;
    }

    /**
     * 设置t属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setT(T value) {
        this.t = value;
    }

}
