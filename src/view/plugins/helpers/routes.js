const home = $(document).on("click", ".home", () => {
  $(location).attr('href',"./pages/users/profile.html");
});

const subject = $(document).on("click", "#subject", () => {
  $(location).attr('href',"./pages/subject.html");
});


const student = $(document).on("click", "#student", () => {
  $(location).attr('href',"./pages/students");
});


const score = $(document).on("click", "#score", () => {
  $(location).attr('href',"./pages/score");
});




