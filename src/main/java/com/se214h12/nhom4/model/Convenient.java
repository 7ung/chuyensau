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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Stevie
 */
@Entity
@Table(name = "convenient")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Convenient.findAll", query = "SELECT c FROM Convenient c"),
    @NamedQuery(name = "Convenient.findById", query = "SELECT c FROM Convenient c WHERE c.id = :id"),
    @NamedQuery(name = "Convenient.findByName", query = "SELECT c FROM Convenient c WHERE c.name = :name")})
public class Convenient implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 128)
    @Column(name = "name")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "convenient")
    private Collection<HotelInfoConvenient> hotelInfoConvenientCollection;

    public Convenient() {
    }

    public Convenient(Integer id) {
        this.id = id;
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
        if (!(object instanceof Convenient)) {
            return false;
        }
        Convenient other = (Convenient) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.se214h12.nhom4.model.Convenient[ id=" + id + " ]";
    }
    
}
