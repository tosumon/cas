/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entities.user;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.servlet.http.Part;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author atinkut
 */
@Entity
@Table(name = "File_Upload")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FileUpload.findAll", query = "SELECT f FROM FileUpload f"),
    @NamedQuery(name = "FileUpload.findByFileId", query = "SELECT f FROM FileUpload f WHERE f.fileId = :fileId"),
    @NamedQuery(name = "FileUpload.findByFileName", query = "SELECT f FROM FileUpload f WHERE f.fileName = :fileName")})
public class FileUpload implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @Column(name = "fileId")
    private Integer fileId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "fileName")
    private String fileName;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Column(name = "content")
    private byte[] content;

    public FileUpload() {
    }

    public FileUpload(Integer fileId) {
        this.fileId = fileId;
    }

    public FileUpload(Integer fileId, String fileName, byte[] content) {
        this.fileId = fileId;
        this.fileName = fileName;
        this.content = content;
    }

    public Integer getFileId() {
        return fileId;
    }

    public void setFileId(Integer fileId) {
        this.fileId = fileId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fileId != null ? fileId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FileUpload)) {
            return false;
        }
        FileUpload other = (FileUpload) object;
        if ((this.fileId == null && other.fileId != null) || (this.fileId != null && !this.fileId.equals(other.fileId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mum.edu.entity.FileUpload[ fileId=" + fileId + " ]";
    }
    
}
