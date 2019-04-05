/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.tdstecnologia.cursojpa.relacionamento;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author dherkyan.silva@datainfo.inf.br
 */
@Entity
@Table(name = "curso_pessoa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CursoPessoa.findAll", query = "SELECT c FROM CursoPessoa c")
    , @NamedQuery(name = "CursoPessoa.findByDataMatricula", query = "SELECT c FROM CursoPessoa c WHERE c.dataMatricula = :dataMatricula")
    , @NamedQuery(name = "CursoPessoa.findByPessoaId", query = "SELECT c FROM CursoPessoa c WHERE c.cursoPessoaPK.pessoaId = :pessoaId")
    , @NamedQuery(name = "CursoPessoa.findByCursoId", query = "SELECT c FROM CursoPessoa c WHERE c.cursoPessoaPK.cursoId = :cursoId")})
public class CursoPessoa implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CursoPessoaPK cursoPessoaPK;
    @Column(name = "data_matricula")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataMatricula;
    
    @JoinColumn(name = "pessoa_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Pessoa pessoa;
    
    @JoinColumn(name = "curso_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Curso curso;

    public CursoPessoa() {
    }

    public CursoPessoa(CursoPessoaPK cursoPessoaPK) {
        this.cursoPessoaPK = cursoPessoaPK;
    }

    public CursoPessoa(int pessoaId, int cursoId) {
        this.cursoPessoaPK = new CursoPessoaPK(pessoaId, cursoId);
    }

    public CursoPessoaPK getCursoPessoaPK() {
        return cursoPessoaPK;
    }

    public void setCursoPessoaPK(CursoPessoaPK cursoPessoaPK) {
        this.cursoPessoaPK = cursoPessoaPK;
    }

    public Date getDataMatricula() {
        return dataMatricula;
    }

    public void setDataMatricula(Date dataMatricula) {
        this.dataMatricula = dataMatricula;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cursoPessoaPK != null ? cursoPessoaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CursoPessoa)) {
            return false;
        }
        CursoPessoa other = (CursoPessoa) object;
        if ((this.cursoPessoaPK == null && other.cursoPessoaPK != null) || (this.cursoPessoaPK != null && !this.cursoPessoaPK.equals(other.cursoPessoaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.tdstecnologia.cursojpa.relacionamento.CursoPessoa[ cursoPessoaPK=" + cursoPessoaPK + " ]";
    }

}
