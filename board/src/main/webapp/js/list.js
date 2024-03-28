// 페이지 영역 가져오기
const pagination = document.querySelector(".pagination");
console.log(pagination);

document.querySelector("[name='search']").addEventListener("submit", (e) => {
  const cr = document.querySelector("[name='criteria']");
  const keyW = document.querySelector("[name='keyword']");

  e.preventDefault();

  if (cr.value == "n") {
    alert("검색조건 설정해 주세요");
    return;
  } else if (!keyW.value) {
    alert("검색어를  입력해 주세요");
    keyW.focus();
    return;
  }

  e.target.submit();
});
