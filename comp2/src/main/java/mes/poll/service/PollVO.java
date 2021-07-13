package mes.poll.service;

/**
 * @Class Name : PollVO.java
 * @Description : Poll VO class
 * @Modification Information
 *
 * @author kym
 * @since 2021-06-18
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class PollVO extends PollDefaultVO{
    private static final long serialVersionUID = 1L;
    
    /** NO */
    private java.math.BigDecimal no;
    
    /** NAME */
    private java.lang.String name;
    
    /** CONTENT */
    private java.lang.String content;
    
    public java.math.BigDecimal getNo() {
        return this.no;
    }
    
    public void setNo(java.math.BigDecimal no) {
        this.no = no;
    }
    
    public java.lang.String getName() {
        return this.name;
    }
    
    public void setName(java.lang.String name) {
        this.name = name;
    }
    
    public java.lang.String getContent() {
        return this.content;
    }
    
    public void setContent(java.lang.String content) {
        this.content = content;
    }
    
}
