# 학원 수업 과정
## Servlet, jsp
### 전체적인 View는 boostrap을 사용하였음

:star:**게시판**

1. **로그인화면(login.jsp, loginController, userController)**
    - 사용자가 ID/PW 입력시 DB에 있는 ID,PW와 일치하면 main화면으로 이동
    - 일치하지 않으면 login화면으로 이동
    - cookie 사용으로 rememberme 체크박스 체크시 다음 로그인 때 ID를 미리 셋팅
    
2. **main화면(main.jsp)**
    - 로그인이 정상적으로 처리됬을때의 화면
    
3. **사용자 리스트(user)**
    - DB에서 모든 users테이블의 정보를 가져와서(ID, 이름, 별명, 등록일시) 출력
    
4. **사용자 페이징(userPagingList)**
    - users테이블의 List를 10건씩 화면에 출력하는 화면
    - 페이지네이션 사용
    - 수업시간에 같이 한 것
    
5. **lprod 페이징 리스트()**
    - lprod 테이블의 List를 10건씩 화면에 출력하는 화면
    - 페이지네이션 사용
    - 과제였음
    
    
