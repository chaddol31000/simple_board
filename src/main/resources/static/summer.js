$(document).ready(function() {
  const fontList = ['맑은 고딕','굴림','돋움','바탕','궁서','NotoSansKR'];
  $('#summernote').summernote({
    height: 450,
    lang: "ko-KR",
    fontNames: fontList,
    fontNamesIgnoreCheck: fontList,
  });
});