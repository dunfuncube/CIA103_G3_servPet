package com.servPet.pdDetails.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;

import com.servPet.carDetails.model.CartDetailsVO;
import com.servPet.pdCateg.model.PdCategVO;
import com.servPet.pdImg.model.PdImgVO;
import com.servPet.pdoItem.model.PdoItemVO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "PRODUCT_DETAILS")
public class PdDetailsVO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "PD_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer pdId;

	@Column(name = "PD_NAME")
	@NotEmpty(message = "產品名稱 請勿空白")
	private String pdName;

	@Column(name = "PD_DESCR")
	@NotEmpty(message = "產品描述 請勿空白")
	private String pdDescr;

	@Column(name = "PD_PRICE")
	@NotNull(message = "商品價格 請勿空白")
	@Min(value = 0L, message = "商品價格 不能小於{value}")
	@Max(value = 99999L, message = "商品價格 不能超過{value}")
	private Integer pdPrice;

	@Column(name = "PD_QTY")
	@NotNull(message = "商品數量 請勿空白")
	@Min(value = 0L, message = "商品數量 不能小於{value}")
	@Max(value = 99999L, message = "商品數量 不能超過{value}")
	private Integer pdQty;

	@Column(name = "PD_WEIGHT")
	@DecimalMin(value = "1.00", message = "商品重量 不能小於{value}")
	private Double pdWeight;

	@Column(name = "PD_SIZE")
	private String pdSize;

	@Column(name = "PD_COLOR")
	private String pdColor;

	@Column(name = "CREATED_AT")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@PastOrPresent(message = "創建日期 必須是今天或之前的日期")
	private java.time.LocalDateTime createdAt;

	@Column(name = "UPDATED_AT")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@PastOrPresent(message = "更新日期 必須是今天或之前的日期")
	private java.time.LocalDateTime updatedAt;

	@Column(name = "PD_STATUS", length = 1, nullable = false)
	@Pattern(regexp = "[0-3]", message = "商品狀態應為 0 (下架), 1 (上架中), 2 (停售), 3 (測試)")
	private String pdStatus;

	@ManyToOne
	@JoinColumn(name = "PD_CATEGORY")
	private PdCategVO pdCategVO;

	@OneToMany(mappedBy = "pdDetailsVO")
	private Set<CartDetailsVO> cartDetailsVO = new HashSet<>();

	@OneToMany(mappedBy = "pdDetailsVO", cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)
	private Set<PdImgVO> pdImgVO = new HashSet<>();

	@OneToMany(mappedBy = "pdDetailsVO", cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)
	private Set<PdoItemVO> pdoItemVO = new HashSet<>();
	

}