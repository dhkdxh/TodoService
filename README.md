# Spring WEB MVC 프로젝트 - TodoService

## 📖 프로젝트 개요

Spring Web MVC를 기반으로 PRG 패턴을 이용하여 todo CRUD 기능을 구현한 프로젝트

---

## 🌟 주요 기능

- **todo 전체 리스트 조회**: db의 todo 테이블에서 등록한 모든 todo list를 /todo/list를 통해 조회합니다.
- **todo 상세 페이지 조회**: todo의 tno 또는 title를 클릭하면 /todo/read?tno=를 통해 해당 todo의 상세페이지로 조회합니다.
- **todo 등록**: /todo/register를 통해 todo를 작성하고 등록합니다.
- **todo 수정**: /todo/read에서 제공하는 수정 버튼으로 /todo/modify?tno=를 요청하여 todo의 title과 dueDate, finished를 수정합니다.
- **todo 삭제**: /todo/modify에서 제공하는 삭제 버튼으로 /todo/remove를 요청하여 해당 todo를 삭제합니다.

---

