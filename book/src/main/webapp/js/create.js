// sumbit 막기
// code(값이 4자리인지 체크), title, writer, price 비어있는거 체크
const code = document.getElementById("code");
const title = document.getElementById("title");
const writer = document.getElementById("writer");
const price = document.getElementById("price");
document.querySelector("form").addEventListener("submit", (e) => {
  e.preventDefault();

  if (!code.value || code.value.length != 4 || isNaN(code.value)) {
    alert("code 값이 비어있거나 숫자 4자리가 아닙니다.");
    code.focus();
    return;
  } else if (!title.value) {
    alert("title 값이 비어있습니다.");
    title.focus();
    return;
  } else if (!writer.value) {
    alert("writer 값이 비어있습니다.");
    writer.focus();
    return;
  } else if (!price.value || isNaN(price.value)) {
    alert("price 값이 비어있거나 숫자가 아닙니다.");
    price.focus();
    return;
  }
  e.target.submit();
});
