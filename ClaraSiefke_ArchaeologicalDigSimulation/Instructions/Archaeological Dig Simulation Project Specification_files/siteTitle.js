var course = new courseParams();
document.writeln("" +
    '<nav class="navbar navbar-expand-lg navbar-dark bg-dark sticky-top">' +
        '<a class="navbar-brand" href="/cs150/schedule.html">'+ course.code +
        ' <span class="modifier">Schedule</span></a>' +
        ' &nbsp;&nbsp;&nbsp;' +
        '<a class="navbar-brand modifier" ' +
            'href="/CollabCenter/">CollaborationCenter</a>' +
        ' &nbsp;&nbsp;&nbsp;' +
        '<a class="navbar-brand modifier" ' +
            'href="https://kit.cs.kzoo.edu/">Kit</a>' +
    '</nav>' +
    "<header>" +
    '<div class="jumbotron text-center" style="margin-bottom:0; background-color: #FFFFFF">'+
    '<h1 class="display-3"><span class="keyword">'+ course.code +'</span> '+ course.name +'</h1>'+
    '<p class="lead">'+ course.quarter +' <span class="keyword">&#8226;</span> Department of Computer Science <span class="keyword">&#8226;</span> Kalamazoo College </p>' +
    '</div> <hr> </header>'
);

function courseParams()
{
    /* Copy and paste appropriate lines from courseParams.js. */
    this.code = "COMP 150";
    this.name = "Object-Oriented Programming";
    this.quarter    = "Spring 2024";
    this.schedule   = "Class Time: MWF 2:45 PM - 4:00 PM";
    this.laboratory = "Lab: T 1:00 PM - 3:00 PM";
    this.room   = "Room OU312";
    this.instructor = "Instructors: Alyce Brady and Sandino Vargas-Pérez";
    this.leftImg = "leftFish.png";
    this.rightImg = "rightFish.png";
    this.maintainedBy = "the Computer Science faculty at Kalamazoo College";
}

