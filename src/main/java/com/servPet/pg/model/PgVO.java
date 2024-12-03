package com.servPet.pg.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//import java.util.Base64;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import com.servPet.pgPic.model.PgPicVO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "PET_GROOMER")
public class PgVO implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	@Id // 主鍵
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 使用自增的方式來生成主鍵
	@Column(name = "PG_ID", nullable = false)
	private Integer pgId;

//	@OneToMany(mappedBy = "pgVO")
//	private List<PgPicVO> pgPicVO = new ArrayList<PgPicVO>();//有序性可重複

//	@OneToMany(mappedBy = "pgVO")
//	private Set<PgOrderVO> pgOrderVO = new HashSet<PgOrderVO>(); //無序性不可重複

	@Column(name = "PG_NAME", nullable = false)
	@NotEmpty(message = "姓名請勿空白")
	@Pattern(regexp = "^[(\u4e00-\u9fa5)(a-zA-Z)]{2,10}$", message = "員工姓名: 只能是中、英文字母、數字和_ , 且長度必需在2到10之間")
	private String pgName;

	@Lob
	@Column(name = "PG_LICENSES", nullable = false)
	@NotEmpty(message = "證件照請勿空白")
	private byte[] pgLicenses;

	@Lob
	@Column(name = "PG_PIC")
	private byte[] pgPic;

	@Column(name = "PG_AREA", nullable = false)
	@NotEmpty(message = "請選取可服務地區")
	private String pgArea;

	@Column(name = "SCH_DATE", nullable = false)
	@NotEmpty(message = "請選取每週可服務日")
	private String schDate;

	@Column(name = "SCH_TIME", nullable = false)
	@NotEmpty(message = "請選取每日可預約時段")
	private String schTime;

	@Column(name = "PG_STATUS")
	private String pgStatus;

	@Column(name = "PG_BIO")
	private String pgBio;

	@Column(name = "PG_PW")
	private String pgPw;

	@Column(name = "PG_EMAIL", nullable = false)
	@NotEmpty(message = "請填寫聯絡信箱")
	@Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", message = "聯絡信箱只能填寫英文字母、數字和_等特定符號。")
	private String pgEmail;

	@Column(name = "TOTAL_STARS")
	private Integer totalStars;

	@Column(name = "RATING_TIMES")
	private Integer ratingTimes;

	@Column(name = "REPORT_TIMES")
	private Integer reportTimes;

	@Column(name = "APPROVAL_STATUS")
	private String approvalStatus;

	public Integer getPgId() {
		return pgId;
	}

	public void setPgId(Integer pgId) {
		this.pgId = pgId;
	}

	public String getPgName() {
		return pgName;
	}

	public void setPgName(String pgName) {
		this.pgName = pgName;
	}

	public byte[] getPgLicenses() {
		return pgLicenses;
	}

	public void setPgLicenses(byte[] pgLicenses) {
		this.pgLicenses = pgLicenses;
	}

	public byte[] getPgPic() {
		return pgPic;
	}

	public void setPgPic(byte[] pgPic) {
		this.pgPic = pgPic;
	}

	public String getPgArea() {
		return pgArea;
	}

	public void setPgArea(String pgArea) {
		this.pgArea = pgArea;
	}

	public String getSchDate() {
		return schDate;
	}

	public void setSchDate(String schDate) {
		this.schDate = schDate;
	}

	public String getSchTime() {
		return schTime;
	}

	public void setSchTime(String schTime) {
		this.schTime = schTime;
	}

	public String getPgStatus() {
		return pgStatus;
	}

	public void setPgStatus(String pgStatus) {
		this.pgStatus = pgStatus;
	}

	public String getPgBio() {
		return pgBio;
	}

	public void setPgBio(String pgBio) {
		this.pgBio = pgBio;
	}

	public String getPgPw() {
		return pgPw;
	}

	public void setPgPw(String pgPw) {
		this.pgPw = pgPw;
	}

	public String getPgEmail() {
		return pgEmail;
	}

	public void setPgEmail(String pgEmail) {
		this.pgEmail = pgEmail;
	}

	public Integer getTotalStars() {
		return totalStars;
	}

	public void setTotalStars(Integer totalStars) {
		this.totalStars = totalStars;
	}

	public Integer getRatingTimes() {
		return ratingTimes;
	}

	public void setRatingTimes(Integer ratingTimes) {
		this.ratingTimes = ratingTimes;
	}

	public Integer getReportTimes() {
		return reportTimes;
	}

	public void setReportTimes(Integer reportTimes) {
		this.reportTimes = reportTimes;
	}

	public String getApprovalStatus() {
		return approvalStatus;
	}

	public void setApprovalStatus(String approvalStatus) {
		this.approvalStatus = approvalStatus;
	}

}