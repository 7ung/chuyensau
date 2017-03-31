/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.se214h12.nhom4.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Stevie
 */
@Entity
@Table(name = "hotel_info")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HotelInfo.findAll", query = "SELECT h FROM HotelInfo h"),
    @NamedQuery(name = "HotelInfo.findById", query = "SELECT h FROM HotelInfo h WHERE h.id = :id"),
    @NamedQuery(name = "HotelInfo.findByName", query = "SELECT h FROM HotelInfo h WHERE h.name = :name"),
    @NamedQuery(name = "HotelInfo.findByDescription", query = "SELECT h FROM HotelInfo h WHERE h.description = :description"),
    @NamedQuery(name = "HotelInfo.findByAddress", query = "SELECT h FROM HotelInfo h WHERE h.address = :address"),
    @NamedQuery(name = "HotelInfo.findByLocationid", query = "SELECT h FROM HotelInfo h WHERE h.locationid = :locationid"),
    @NamedQuery(name = "HotelInfo.findByPhone", query = "SELECT h FROM HotelInfo h WHERE h.phone = :phone"),
    @NamedQuery(name = "HotelInfo.findByFacebook", query = "SELECT h FROM HotelInfo h WHERE h.facebook = :facebook"),
    @NamedQuery(name = "HotelInfo.findBySquare", query = "SELECT h FROM HotelInfo h WHERE h.square = :square"),
    @NamedQuery(name = "HotelInfo.findByPriceMin", query = "SELECT h FROM HotelInfo h WHERE h.priceMin = :priceMin"),
    @NamedQuery(name = "HotelInfo.findByPriceMax", query = "SELECT h FROM HotelInfo h WHERE h.priceMax = :priceMax"),
    @NamedQuery(name = "HotelInfo.findByElectricalPrice", query = "SELECT h FROM HotelInfo h WHERE h.electricalPrice = :electricalPrice"),
    @NamedQuery(name = "HotelInfo.findByWaterPrice", query = "SELECT h FROM HotelInfo h WHERE h.waterPrice = :waterPrice"),
    @NamedQuery(name = "HotelInfo.findByMaxRoom", query = "SELECT h FROM HotelInfo h WHERE h.maxRoom = :maxRoom"),
    @NamedQuery(name = "HotelInfo.findByEmptyRoom", query = "SELECT h FROM HotelInfo h WHERE h.emptyRoom = :emptyRoom"),
    @NamedQuery(name = "HotelInfo.findByType", query = "SELECT h FROM HotelInfo h WHERE h.type = :type"),
    @NamedQuery(name = "HotelInfo.findBySpecialOrder", query = "SELECT h FROM HotelInfo h WHERE h.specialOrder = :specialOrder")})
public class HotelInfo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "name")
    private String name;
    @Size(max = 45)
    @Column(name = "description")
    private String description;
    @Size(max = 256)
    @Column(name = "address")
    private String address;
    @Column(name = "locationid")
    private Integer locationid;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 16)
    @Column(name = "phone")
    private String phone;
    @Size(max = 256)
    @Column(name = "facebook")
    private String facebook;
    @Column(name = "square")
    private Integer square;
    @Column(name = "price_min")
    private Integer priceMin;
    @Column(name = "price_max")
    private Integer priceMax;
    @Column(name = "electrical_price")
    private Integer electricalPrice;
    @Column(name = "water_price")
    private Integer waterPrice;
    @Column(name = "max_room")
    private Integer maxRoom;
    @Column(name = "empty_room")
    private Integer emptyRoom;
    @Column(name = "type")
    private Integer type;
    @Size(max = 256)
    @Column(name = "special_order")
    private String specialOrder;
    @OneToMany(mappedBy = "hotelId")
    private Collection<HotelComment> hotelCommentCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "hotelInfo")
    private Collection<HotelInfoConvenient> hotelInfoConvenientCollection;

    public HotelInfo() {
    }

    public HotelInfo(Integer id) {
        this.id = id;
    }

    public HotelInfo(Integer id, String name) {
        this.id = id;
        this.name = name;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getLocationid() {
        return locationid;
    }

    public void setLocationid(Integer locationid) {
        this.locationid = locationid;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public Integer getSquare() {
        return square;
    }

    public void setSquare(Integer square) {
        this.square = square;
    }

    public Integer getPriceMin() {
        return priceMin;
    }

    public void setPriceMin(Integer priceMin) {
        this.priceMin = priceMin;
    }

    public Integer getPriceMax() {
        return priceMax;
    }

    public void setPriceMax(Integer priceMax) {
        this.priceMax = priceMax;
    }

    public Integer getElectricalPrice() {
        return electricalPrice;
    }

    public void setElectricalPrice(Integer electricalPrice) {
        this.electricalPrice = electricalPrice;
    }

    public Integer getWaterPrice() {
        return waterPrice;
    }

    public void setWaterPrice(Integer waterPrice) {
        this.waterPrice = waterPrice;
    }

    public Integer getMaxRoom() {
        return maxRoom;
    }

    public void setMaxRoom(Integer maxRoom) {
        this.maxRoom = maxRoom;
    }

    public Integer getEmptyRoom() {
        return emptyRoom;
    }

    public void setEmptyRoom(Integer emptyRoom) {
        this.emptyRoom = emptyRoom;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getSpecialOrder() {
        return specialOrder;
    }

    public void setSpecialOrder(String specialOrder) {
        this.specialOrder = specialOrder;
    }

    @XmlTransient
    public Collection<HotelComment> getHotelCommentCollection() {
        return hotelCommentCollection;
    }

    public void setHotelCommentCollection(Collection<HotelComment> hotelCommentCollection) {
        this.hotelCommentCollection = hotelCommentCollection;
    }

    @XmlTransient
    public Collection<HotelInfoConvenient> getHotelInfoConvenientCollection() {
        return hotelInfoConvenientCollection;
    }

    public void setHotelInfoConvenientCollection(Collection<HotelInfoConvenient> hotelInfoConvenientCollection) {
        this.hotelInfoConvenientCollection = hotelInfoConvenientCollection;
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
        if (!(object instanceof HotelInfo)) {
            return false;
        }
        HotelInfo other = (HotelInfo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.se214h12.nhom4.model.HotelInfo[ id=" + id + " ]";
    }
    
}
