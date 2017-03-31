/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.se214h12.nhom4.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Stevie
 */
@Entity
@Table(name = "hotel_comment")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HotelComment.findAll", query = "SELECT h FROM HotelComment h"),
    @NamedQuery(name = "HotelComment.findById", query = "SELECT h FROM HotelComment h WHERE h.id = :id"),
    @NamedQuery(name = "HotelComment.findByContent", query = "SELECT h FROM HotelComment h WHERE h.content = :content"),
    @NamedQuery(name = "HotelComment.findByParent", query = "SELECT h FROM HotelComment h WHERE h.parent = :parent")})
public class HotelComment implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 512)
    @Column(name = "content")
    private String content;
    @Column(name = "parent")
    private Integer parent;
    @JoinColumn(name = "hotel_id", referencedColumnName = "id")
    @ManyToOne
    private HotelInfo hotelId;
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private User userId;

    public HotelComment() {
    }

    public HotelComment(Integer id) {
        this.id = id;
    }

    public HotelComment(Integer id, String content) {
        this.id = id;
        this.content = content;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getParent() {
        return parent;
    }

    public void setParent(Integer parent) {
        this.parent = parent;
    }

    public HotelInfo getHotelId() {
        return hotelId;
    }

    public void setHotelId(HotelInfo hotelId) {
        this.hotelId = hotelId;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HotelComment)) {
            return false;
        }
        HotelComment other = (HotelComment) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.se214h12.nhom4.model.HotelComment[ id=" + id + " ]";
    }
    
}
