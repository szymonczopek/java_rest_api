document.addEventListener('DOMContentLoaded', () => {
    getAllStudents();
});

function deleteStudent(){
    const form = document.getElementById('student-form');
    var id = form.elements.id.value;
    fetch("http://localhost:8080/student/" + id, {
        method: 'DELETE',
        headers: {
            'Content-Type': 'application/json',
        }
    })
        .then((response) => {

                response.text().then(body => komunikat(body));

        })
        .then(getAllStudents)
}

function addStudent()
{
    const form = document.getElementById('student-form');
    var student = {};
    student.name = form.elements.name.value;
    student.surName = form.elements.surName.value;
    student.average = form.elements.average.value;
    fetch("http://localhost:8080/student", {
        method: 'POST',
        body: JSON.stringify(student),
        headers: {
            'Content-Type': 'application/json',
        }
    })
        .then((response) => {
            response.text().then(body => komunikat(body));
        }).then(getAllStudents)

}
function modifyStudent()
{
    const form = document.getElementById('student-form');
    var student = {};
    student.id = form.elements.id.value;
    student.name = form.elements.name.value;
    student.surName = form.elements.surName.value;
    student.average = form.elements.average.value;
    fetch("http://localhost:8080/student", {
        method: 'PUT',
        body: JSON.stringify(student),
        headers: {
            'Content-Type': 'application/json',
        }
    })
        .then((response) => {

                response.text().then(body => komunikat(body));

        })
        .then(getAllStudents)

}

function getAllStudents() {
    fetch("http://localhost:8080/students", {
        method: 'GET',
        //mode: 'no-cors',
        headers: {
            'Content-Type': 'application/json',
        }
    })
        .then((response) => {
            if (response.status !== 200) {
                console.log(response.json());
                return Promise.reject('Coś poszło nie tak!');
            }
            return response.json();
        })
        .then((data) => {
            pokazTabele(data);
        })
        .catch((error) => {
            console.log(error);
        });
}

function pokazTabele(response) {
    console.log(response)
    var main = document.getElementById('main');
    var content = "<table> <thead> <tr> <th> Id</th><th> Imię</th>" +
        "<th>Nazwisko</th><th>Średnia</th></tr></thead><tbody>";
    for (var st in response) {
        var id = response[st].id;
        var name = response[st].name;
        var surname = response[st].surName;
        var average = response[st].average;
        content += "<tr><td>" + id + "</td></td><td>" + name + "</td><td>" + surname +
            "</td><td>" + average + "</td></tr>";
    }
    content += "</tbody></table>";
    main.innerHTML = content;
}

function komunikat(body){
    var komunikat = document.getElementById('komunikat');
    content = "<h2>" + body + "</h2>"
    komunikat.innerHTML = content
}