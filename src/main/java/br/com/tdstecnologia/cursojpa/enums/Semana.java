package br.com.tdstecnologia.cursojpa.enums;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "tb_semana")
@XmlRootElement
public class Semana implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(name = "TEXTO")
    private EnumSemama diaSemanaNome;
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "INDICE")
    private EnumSemama diaSemanaIndice;
    
    
    @Convert(converter = EnumSemanaConverterNome.class)
    @Column(name = "TEXTO_CUSTOM")
    private EnumSemama diaSemanaNomeCustom;
    @Convert(converter = EnumSemanaConverterIndice.class)
    @Column(name = "INDICE_CUSTOM")
    private EnumSemama diaSemanaIndiceCustom;
    
    
        
    

    public Semana() {
    }

    public Semana(Integer id) {
        this.id = id;
    }

    public EnumSemama getDiaSemanaNome() {
        return diaSemanaNome;
    }

    public void setDiaSemanaNome(EnumSemama diaSemanaNome) {
        this.diaSemanaNome = diaSemanaNome;
    }

    public EnumSemama getDiaSemanaIndice() {
        return diaSemanaIndice;
    }

    public void setDiaSemanaIndice(EnumSemama diaSemanaIndice) {
        this.diaSemanaIndice = diaSemanaIndice;
    }

    public EnumSemama getDiaSemanaNomeCustom() {
        return diaSemanaNomeCustom;
    }

    public void setDiaSemanaNomeCustom(EnumSemama diaSemanaNomeCustom) {
        this.diaSemanaNomeCustom = diaSemanaNomeCustom;
    }

    public EnumSemama getDiaSemanaIndiceCustom() {
        return diaSemanaIndiceCustom;
    }

    public void setDiaSemanaIndiceCustom(EnumSemama diaSemanaIndiceCustom) {
        this.diaSemanaIndiceCustom = diaSemanaIndiceCustom;
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
        if (!(object instanceof Semana)) {
            return false;
        }
        Semana other = (Semana) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.tdstecnologia.cursojpa.enums.TbEnum[ id=" + id + " ]";
    }

}
