package com.test.CurrencyManagement.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Currency {
	@Id
	@Column(length = 15, name = "CURNCYID", unique = true, nullable = false)
	private Character currencyId;

	@Column(name = "CURRNIDX", unique = true, nullable = true)
	private Integer currencyIndex;

	@Column(length = 31, name = "CRNCYDSC", unique = true, nullable = false)
	private Character currencyDesc;

	@Column(length = 61, name = "CRNCYDSCA", unique = true, nullable = false)
	private Character currencyDescArabic;

	@Column(length = 3, name = "CRNCYSYM", unique = true, nullable = false)
	private Character currencySymbol;
//columnDefinition="SMALLINT(1)"
	@Column(name = "INCLSPAC", unique = true, nullable = false , columnDefinition="BIT")
	private boolean includeSpaceAfterSymbol;

	@Column(name = "NEGSYMBL", unique = true, nullable = false ,columnDefinition="SMALLINT(2)")
	private Integer negativeSymbol;

	@Column(name = "NGSMAMPC", unique = true, nullable = false ,columnDefinition="SMALLINT(2)")
	private Integer displayNegativeSign;

	@Column(name = "DECSYMBL", unique = true, nullable = false ,columnDefinition="SMALLINT(2)")
	private Integer seperatorDecimal;

	@Column(name = "THOUSSYM", unique = true, nullable = false ,columnDefinition="SMALLINT(2)")
	private Integer seperatorThousand;

	@Column(length = 25, name = "CURTEXT_1", unique = true, nullable = false)
	private Character currencyUnit;

	@Column(length = 25, name = "CURTEXT_2", unique = true, nullable = false)
	private Character subunitConnector;

	@Column(length = 25, name = "CURTEXT_3", unique = true, nullable = false)
	private Character currencySubunit;

	@Column(length = 55, name = "CURTEXTA_1", unique = true, nullable = false)
	private Character currencyUnitArabic;

	@Column(length = 55, name = "CURTEXTA_2", unique = true, nullable = false)
	private Character subunitConnectorArabic;

	@Column(length = 55, name = "CURTEXTA_3", unique = true, nullable = false)
	private Character currencySubunitArabic;

	@DateTimeFormat
	@Column(name = "DEX_ROW_TS", unique = true, nullable = false)
	private Date rowDateIndexing;

	@Column(name = "DEX_ROW_ID", unique = true, nullable = false)
	private Integer rowIdIndex;

	public Currency() {
	}

	public Currency(Character currencyId, Integer currencyIndex, Character currencyDesc, Character currencyDescArabic,
			Character currencySymbol, boolean includeSpaceAfterSymbol, Integer negativeSymbol,
			Integer displayNegativeSign, Integer seperatorDecimal, Integer seperatorThousand, Character currencyUnit,
			Character subunitConnector, Character currencySubunit, Character currencyUnitArabic,
			Character subunitConnectorArabic, Character currencySubunitArabic, Date rowDateIndexing,
			Integer rowIdIndex) {
		super();
		this.currencyId = currencyId;
		this.currencyIndex = currencyIndex;
		this.currencyDesc = currencyDesc;
		this.currencyDescArabic = currencyDescArabic;
		this.currencySymbol = currencySymbol;
		this.includeSpaceAfterSymbol = includeSpaceAfterSymbol;
		this.negativeSymbol = negativeSymbol;
		this.displayNegativeSign = displayNegativeSign;
		this.seperatorDecimal = seperatorDecimal;
		this.seperatorThousand = seperatorThousand;
		this.currencyUnit = currencyUnit;
		this.subunitConnector = subunitConnector;
		this.currencySubunit = currencySubunit;
		this.currencyUnitArabic = currencyUnitArabic;
		this.subunitConnectorArabic = subunitConnectorArabic;
		this.currencySubunitArabic = currencySubunitArabic;
		this.rowDateIndexing = rowDateIndexing;
		this.rowIdIndex = rowIdIndex;
	}

	public Character getCurrencyId() {
		return currencyId;
	}

	public void setCurrencyId(Character currencyId) {
		this.currencyId = currencyId;
	}

	public Integer getCurrencyIndex() {
		return currencyIndex;
	}

	public void setCurrencyIndex(Integer currencyIndex) {
		this.currencyIndex = currencyIndex;
	}

	public Character getCurrencyDesc() {
		return currencyDesc;
	}

	public void setCurrencyDesc(Character currencyDesc) {
		this.currencyDesc = currencyDesc;
	}

	public Character getCurrencyDescArabic() {
		return currencyDescArabic;
	}

	public void setCurrencyDescArabic(Character currencyDescArabic) {
		this.currencyDescArabic = currencyDescArabic;
	}

	public Character getCurrencySymbol() {
		return currencySymbol;
	}

	public void setCurrencySymbol(Character currencySymbol) {
		this.currencySymbol = currencySymbol;
	}

	public boolean isIncludeSpaceAfterSymbol() {
		return includeSpaceAfterSymbol;
	}

	public void setIncludeSpaceAfterSymbol(boolean includeSpaceAfterSymbol) {
		this.includeSpaceAfterSymbol = includeSpaceAfterSymbol;
	}

	public Integer getNegativeSymbol() {
		return negativeSymbol;
	}

	public void setNegativeSymbol(Integer negativeSymbol) {
		this.negativeSymbol = negativeSymbol;
	}

	public Integer getDisplayNegativeSign() {
		return displayNegativeSign;
	}

	public void setDisplayNegativeSign(Integer displayNegativeSign) {
		this.displayNegativeSign = displayNegativeSign;
	}

	public Integer getSeperatorDecimal() {
		return seperatorDecimal;
	}

	public void setSeperatorDecimal(Integer seperatorDecimal) {
		this.seperatorDecimal = seperatorDecimal;
	}

	public Integer getSeperatorThousand() {
		return seperatorThousand;
	}

	public void setSeperatorThousand(Integer seperatorThousand) {
		this.seperatorThousand = seperatorThousand;
	}

	public Character getCurrencyUnit() {
		return currencyUnit;
	}

	public void setCurrencyUnit(Character currencyUnit) {
		this.currencyUnit = currencyUnit;
	}

	public Character getSubunitConnector() {
		return subunitConnector;
	}

	public void setSubunitConnector(Character subunitConnector) {
		this.subunitConnector = subunitConnector;
	}

	public Character getCurrencySubunit() {
		return currencySubunit;
	}

	public void setCurrencySubunit(Character currencySubunit) {
		this.currencySubunit = currencySubunit;
	}

	public Character getCurrencyUnitArabic() {
		return currencyUnitArabic;
	}

	public void setCurrencyUnitArabic(Character currencyUnitArabic) {
		this.currencyUnitArabic = currencyUnitArabic;
	}

	public Character getSubunitConnectorArabic() {
		return subunitConnectorArabic;
	}

	public void setSubunitConnectorArabic(Character subunitConnectorArabic) {
		this.subunitConnectorArabic = subunitConnectorArabic;
	}

	public Character getCurrencySubunitArabic() {
		return currencySubunitArabic;
	}

	public void setCurrencySubunitArabic(Character currencySubunitArabic) {
		this.currencySubunitArabic = currencySubunitArabic;
	}

	public Date getRowDateIndexing() {
		return rowDateIndexing;
	}

	public void setRowDateIndexing(Date rowDateIndexing) {
		this.rowDateIndexing = rowDateIndexing;
	}

	public Integer getRowIdIndex() {
		return rowIdIndex;
	}

	public void setRowIdIndex(Integer rowIdIndex) {
		this.rowIdIndex = rowIdIndex;
	}

	@Override
	public String toString() {
		return "Currency [currencyId=" + currencyId + ", currencyIndex=" + currencyIndex + ", currencyDesc="
				+ currencyDesc + ", currencyDescArabic=" + currencyDescArabic + ", currencySymbol=" + currencySymbol
				+ ", includeSpaceAfterSymbol=" + includeSpaceAfterSymbol + ", negativeSymbol=" + negativeSymbol
				+ ", displayNegativeSign=" + displayNegativeSign + ", seperatorDecimal=" + seperatorDecimal
				+ ", seperatorThousand=" + seperatorThousand + ", currencyUnit=" + currencyUnit + ", subunitConnector="
				+ subunitConnector + ", currencySubunit=" + currencySubunit + ", currencyUnitArabic="
				+ currencyUnitArabic + ", subunitConnectorArabic=" + subunitConnectorArabic + ", currencySubunitArabic="
				+ currencySubunitArabic + ", rowDateIndexing=" + rowDateIndexing + ", rowIdIndex=" + rowIdIndex + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + currencyDesc;
		result = prime * result + currencyDescArabic;
		result = prime * result + currencyId;
		result = prime * result + ((currencyIndex == null) ? 0 : currencyIndex.hashCode());
		result = prime * result + currencySubunit;
		result = prime * result + currencySubunitArabic;
		result = prime * result + currencySymbol;
		result = prime * result + currencyUnit;
		result = prime * result + currencyUnitArabic;
		result = prime * result + ((displayNegativeSign == null) ? 0 : displayNegativeSign.hashCode());
		result = prime * result + (includeSpaceAfterSymbol ? 1231 : 1237);
		result = prime * result + ((negativeSymbol == null) ? 0 : negativeSymbol.hashCode());
		result = prime * result + ((rowDateIndexing == null) ? 0 : rowDateIndexing.hashCode());
		result = prime * result + ((rowIdIndex == null) ? 0 : rowIdIndex.hashCode());
		result = prime * result + ((seperatorDecimal == null) ? 0 : seperatorDecimal.hashCode());
		result = prime * result + ((seperatorThousand == null) ? 0 : seperatorThousand.hashCode());
		result = prime * result + subunitConnector;
		result = prime * result + subunitConnectorArabic;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Currency other = (Currency) obj;
		if (currencyDesc != other.currencyDesc)
			return false;
		if (currencyDescArabic != other.currencyDescArabic)
			return false;
		if (currencyId != other.currencyId)
			return false;
		if (currencyIndex == null) {
			if (other.currencyIndex != null)
				return false;
		} else if (!currencyIndex.equals(other.currencyIndex))
			return false;
		if (currencySubunit != other.currencySubunit)
			return false;
		if (currencySubunitArabic != other.currencySubunitArabic)
			return false;
		if (currencySymbol != other.currencySymbol)
			return false;
		if (currencyUnit != other.currencyUnit)
			return false;
		if (currencyUnitArabic != other.currencyUnitArabic)
			return false;
		if (displayNegativeSign == null) {
			if (other.displayNegativeSign != null)
				return false;
		} else if (!displayNegativeSign.equals(other.displayNegativeSign))
			return false;
		if (includeSpaceAfterSymbol != other.includeSpaceAfterSymbol)
			return false;
		if (negativeSymbol == null) {
			if (other.negativeSymbol != null)
				return false;
		} else if (!negativeSymbol.equals(other.negativeSymbol))
			return false;
		if (rowDateIndexing == null) {
			if (other.rowDateIndexing != null)
				return false;
		} else if (!rowDateIndexing.equals(other.rowDateIndexing))
			return false;
		if (rowIdIndex == null) {
			if (other.rowIdIndex != null)
				return false;
		} else if (!rowIdIndex.equals(other.rowIdIndex))
			return false;
		if (seperatorDecimal == null) {
			if (other.seperatorDecimal != null)
				return false;
		} else if (!seperatorDecimal.equals(other.seperatorDecimal))
			return false;
		if (seperatorThousand == null) {
			if (other.seperatorThousand != null)
				return false;
		} else if (!seperatorThousand.equals(other.seperatorThousand))
			return false;
		if (subunitConnector != other.subunitConnector)
			return false;
		if (subunitConnectorArabic != other.subunitConnectorArabic)
			return false;
		return true;
	}

}
