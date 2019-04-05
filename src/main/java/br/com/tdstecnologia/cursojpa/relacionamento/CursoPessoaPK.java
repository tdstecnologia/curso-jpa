/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.tdstecnologia.cursojpa.relacionamento;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author dherkyan.silva@datainfo.inf.br
 */
@Embeddable
public class CursoPessoaPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "pessoa_id")
    private int pessoaId;
    @Basic(optional = false)
    @Column(name = "curso_id")
    private int cursoId;

    public CursoPessoaPK() {
    }

    public CursoPessoaPK(int pessoaId, int cursoId) {
        this.pessoaId = pessoaId;
        this.cursoId = cursoId;
    }

    public int getPessoaId() {
        return pessoaId;
    }

    public void setPessoaId(int pessoaId) {
        this.pessoaId = pessoaId;
    }

    public int getCursoId() {
        return cursoId;
    }

    public void setCursoId(int cursoId) {
        this.cursoId = cursoId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) pessoaId;
        hash += (int) cursoId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CursoPessoaPK)) {
            return false;
        }
        CursoPessoaPK other = (CursoPessoaPK) object;
        if (this.pessoaId != other.pessoaId) {
            return false;
        }
        if (this.cursoId != other.cursoId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.tdstecnologia.cursojpa.relacionamento.CursoPessoaPK[ pessoaId=" + pessoaId + ", cursoId=" + cursoId + " ]";
    }

}
