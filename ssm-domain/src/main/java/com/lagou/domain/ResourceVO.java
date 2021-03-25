package com.lagou.domain;

public class ResourceVO {

  private Integer currentPage;

  private Integer pageSize;

  private String name;

  private String url;

  private Integer categoryId;

  @Override
  public String toString() {
    return "ResourceVO{" +
      "currentPage=" + currentPage +
      ", pageSize=" + pageSize +
      ", name='" + name + '\'' +
      ", url='" + url + '\'' +
      ", categoryId=" + categoryId +
      '}';
  }

  public Integer getCurrentPage() {
    return currentPage;
  }

  public void setCurrentPage(Integer currentPage) {
    this.currentPage = currentPage;
  }

  public Integer getPageSize() {
    return pageSize;
  }

  public void setPageSize(Integer pageSize) {
    this.pageSize = pageSize;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public Integer getCategoryId() {
    return categoryId;
  }

  public void setCategoryId(Integer categoryId) {
    this.categoryId = categoryId;
  }
}
