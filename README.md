# 학원 수업 과정
## Servlet, jsp
### 전체적인 View는 boostrap을 사용하였음

:star:**게시판**

1. **로그인화면(login.jsp, loginController, userController)**
    - 사용자가 ID/PW 입력시 DB에 있는 ID,PW와 일치하면 main화면으로 이동
    - 비밀번호는 암호화 모듈을 사용하여 DB에 있는 비밀번호와 일치하는지 확인
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
    
5. **lprod 페이징 리스트(userLprodList)**
    - lprod 테이블의 List를 10건씩 화면에 출력하는 화면
    - 페이지네이션 사용
    - 과제였음
<hr/>
    
:star:[암호화 모듈](https://github.com/wthswngud/jsp/tree/master/src/test/java/kr/or/ddit/encrypt/kisa)  
:star:[네이버 SMART_EDITOR](https://github.com/wthswngud/jsp/tree/master/src/main/webapp/SE2)  
:star:[request, response](https://github.com/wthswngud/jsp/tree/master/src/main/webapp/jsp)  
:star:[Filter](https://github.com/wthswngud/jsp/tree/master/src/main/java/kr/or/ddit/filter)  
:star:[Listener](https://github.com/wthswngud/jsp/tree/master/src/main/java/kr/or/ddit/listener)  
