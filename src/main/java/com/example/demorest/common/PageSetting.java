package com.example.demo.common;

// 페이징처리를 위한 기준 클래스
// 페이지 당 게시글의 갯수를 파라미터를 받을 경우, LIMIT #{pageStart} #{perPageNum} 처리를 위한 클래스
public class PageSetting {

    private int page;           // 현재 페이지 번호
    private int rowSize;     // 페이지 당 보여지는 게시글의 갯수

    // 기본 생성자 : 1페이지, 페이지당 20개의 게시글로 초기화
    public PageSetting() {

        this.page = 1;
        this.rowSize = 20;

    }

    // setPage(), setPerPageNum() 메서드에 잘못된 값이 입력되는 경우, 강제로 값을 조정
    public void setPage(int page) {

        // 0 이하 일 경우 1로 강제
        if (page <= 0) {
            this.page = 1;
            return;
        }

        this.page = page;
    }

    public void setRowSize(int rowSize) {

        // 0 이하, 100보다 클 경우 10으로 강제
        if (rowSize <=0 || rowSize > 100) {
            this.rowSize = 10;
            return;
        }

        this.rowSize = rowSize;
    }

    public int getPage() {

        return page;

    }

    // boardMapper.xml(listCriteria) SQL을 위한 메서드
    // limit 구문에서 현재 페이지의 게시물의 시작번호를 지정하기 위해
    public int getPageStart() {

        // 예를 들어 페이지당 10개의 게시물을 출력하는 경우, 3페이지의 첫번째 게시물을 출력한다면 ?
        // 전체 게시글 중에서 정렬한 데이터의 index의 21번째 데이터, 즉 20
        // LIMIT 20, 10
        return (this.page - 1) * rowSize;

    }

    // boardMapper.xml(listCriteria) SQL을 위한 메서드
    // limit 구문에서 페이지 당 게시물의 갯수를 지정하기 위해
    public int getRowSize() {

        return this.rowSize;

    }

    @Override
    public String toString() {
        return "Criteria{" +
                "page=" + page +
                ", rowSize=" + rowSize +
                '}';
    }
}