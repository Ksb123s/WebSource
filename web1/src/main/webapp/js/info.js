// submit 클릭시
// 값이 비어있지 않도록 체크

const id = document.getElementById("id");
const Name = document.getElementById("name");
const age = document.getElementById("age");
const form = document.querySelector("form");
let str = "";

form.addEventListener("submit", (e) => {
  e.preventDefault();
  if (!id.value) {
    str = "아이디를 입력해 주세요.";
    alert(str);
    id.focus();
    return;
  } else if (!Name.value) {
    str = "이름을 입력해 주세요.";
    alert(str);
    Name.focus();
    return;
  } else if (!age.value || isNaN(age.value)) {
    str = "나이를 입력해 주세요.";
    alert(str);
    age.focus();
    return;
  }

  form.submit();
});
