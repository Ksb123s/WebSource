document.querySelector("form").addEventListener("submit", (e) => {
  e.preventDefault();

  const Name = document.getElementById("name");
  const content = document.getElementById("content");
  const password = document.getElementById("password");
  const title = document.getElementById("title");

  if (!Name.value) {
    alert("이름을 확인해 주세요");
    Name.focus();
    return;
  } else if (!title.value) {
    alert("제목을 확인해 주세요");
    title.focus();
    return;
  } else if (!content.value) {
    alert("내용을 확인해 주세요");
    content.focus();
    return;
  } else if (!password.value) {
    alert("비번을 확인해 주세요");
    password.focus();
    return;
  }

  e.target.submit();
});

document.querySelector("#list").addEventListener("click", () => {
  location.href = "/qList.do";
});
