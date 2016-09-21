package com.shangliwei.phoenix.util;

public class Pagination {

	private int countRow;
	private int pageSize;
	private int currentPage;
	
	public Pagination(int countRow, int pageSize, int currentPage) {
		super();
		this.countRow = countRow;
		this.pageSize = pageSize;
		this.currentPage = currentPage;
	}

	public int getCountRow() {
		return countRow;
	}

	public void setCountRow(int countRow) {
		this.countRow = countRow;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getBeginRow() {
		int result = 0;
		if (this.currentPage == 1) {
			result = 1;
		} else {
			result = (this.currentPage - 1) * this.pageSize + 1;
		}
		return result;
	}

	public int getEndRow() {
		int result = 0;
		if (this.currentPage == this.getCountPage()) {
			result = this.countRow;
		} else {
			result = this.getBeginRow() + this.pageSize - 1;
		}
		return result;
	}

	public int getCountPage() {
		int result = 0;
		if (this.countRow < this.pageSize) {
			result = 1;
		} else {
			result = (int) Math.ceil((double) this.countRow / this.pageSize);
		}
		return result;
	}

}
