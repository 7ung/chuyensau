/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.se214h12.nhom4.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Stevie
 */
@Entity
@Table(name = "hotel_info_convenient")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HotelInfoConvenient.findAll", query = "SELECT h FROM HotelInfoConvenient h"),
    @NamedQuery(name = "HotelInfoConvenient.findByHotelId", query = "SELECT h FROM HotelInfoConvenient h WHERE h.hotelInfoConvenientPK.hotelId = :hotelId"),
    @NamedQuery(name = "HotelInfoConvenient.findByConvenientId", query = "SELECT h FROM HotelInfoConvenient h WHERE h.hotelInfoConvenientPK.convenientId = :convenientId"),
    @NamedQuery(name = "HotelInfoConvenient.findByDescription", query = "SELECT h FROM HotelInfoConvenient h WHERE h.description = :description")})
public class HotelInfoConvenient implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected HotelInfoConvenientPK hotelInfoConvenientPK;
    @Size(max = 256)
    @Column(name = "description")
    private String description;
    @JoinColumn(name = "convenient_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Convenient convenient;
    @JoinColumn(name = "hotel_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private HotelInfo hotelInfo;

    public HotelInfoConvenient() {
    }

    public HotelInfoConvenient(HotelInfoConvenientPK hotelInfoConvenientPK) {
        this.hotelInfoConvenientPK = hotelInfoConvenientPK;
    }

    public HotelInfoConvenient(int hotelId, int convenientId) {
        this.hotelInfoConvenientPK = new HotelInfoConvenientPK(hotelId, convenientId);
    }

    public HotelInfoConvenientPK getHotelInfoConvenientPK() {
        return hotelInfoConvenientPK;
    }

    public void setHotelInfoConvenientPK(HotelInfoConvenientPK hotelInfoConvenientPK) {
        this.hotelInfoConvenientPK = hotelInfoConvenientPK;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Convenient getConvenient() {
        return convenient;
    }

    public void setConvenient(Convenient convenient) {
        this.convenient = convenient;
    }

    public HotelInfo getHotelInfo() {
        return hotelInfo;
    }

    public void setHotelInfo(HotelInfo hotelInfo) {
        this.hotelInfo = hotelInfo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (hotelInfoConvenientPK != null ? hotelInfoConvenientPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HotelInfoConvenient)) {
            return false;
        }
        HotelInfoConvenient other = (HotelInfoConvenient) object;
        if ((this.hotelInfoConvenientPK == null && other.hotelInfoConvenientPK != null) || (this.hotelInfoConvenientPK != null && !this.hotelInfoConvenientPK.equals(other.hotelInfoConvenientPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.se214h12.nhom4.model.HotelInfoConvenient[ hotelInfoConvenientPK=" + hotelInfoConvenientPK + " ]";
    }
    
}
