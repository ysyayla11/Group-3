<%@ page import="bacit.web.bacit_web.DAO.UserDAO" %>
<%@ page import="bacit.web.bacit_web.models.UserModel" %>
<%@ page import="bacit.web.bacit_web.DAO.AccessDAO" %>
<html>
<head>
    <title>book verktøy</title>
    <link href="styles.css" rel="stylesheet" type="text/css">
    <meta charset="UTF-8"></head>

<body>

<div id="bookingInterface">
    <div>Du skylder: X kroner</div>
    <div>Du har: X ubetalte bookinger</div>
    <button>betal alle ubetalt bookinger</button><br>

    <b>Dine bookinger:</b><br>
    <label>Sorter etter</label>
    <select id="sortSelect">
        <option selected>Ubetalte</option>
        <option>Ulevert</option>
        <option>Kommende</option>
        <option>Alle</option>
    </select>
</div>

<input type="date" id="dateInput">

<!--

klasser:
Ubetalt,
Ulevert,
Kommende,
-->

<ul>
    <li class="bookingLi ubetalt" style="">
    <br><div><b>9` vinkelsliper 230VAC</b></div><br>
    <div> start: 2021-11-23</div>
    <div> slutt: 2021-11-26</div>
    <br><div>Denne bookingen er betalt</div>
    <div><button>Rapporter skade</button></div>
    <div>Du leverte dette verktøyet: 2021-11-20 00:00:00.0</div>
</li><br>

    <li class="bookingLi ubetalt ulevert" style="">
    <br><div><b>Vedkløyver bensindrevet</b></div>
    <div> start: 2021-11-23</div>
    <div> slutt: 2021-11-27</div>
    <br><div>Denne bookingen er betalt</div>
    <div><button>Rapporter skade</button></div>
    <div>Du leverte dette verktøyet: 2021-11-21 00:00:00.0</div>
</li><br>

    <li class="bookingLi ubetalt ulevert" style="">
    <br><div><b>Skruautomat</b></div>
    <div> start: 2021-11-21</div>
    <div> slutt: 2021-11-22</div>
    <br><div>Denne bookingen er betalt</div>
    <div><button>Rapporter skade</button></div>
    <div><a href="markToolDeliveredServlet?booking_id=6&amp;tool_id=13"><button>Marker som levert</button></a></div>
</li><br>

    <li class="bookingLi" style="">
    <br><div><b>Kompressor, 230VAC</b></div>
    <div> start: 2021-11-01</div>
    <div> slutt: 2021-11-10</div>
    <br><div>Du skylder 200 kr for denne bookingen <br><a href="markBookingPaidServlet?booking_id=7"><button class="paymentButton">Betal nå med vipps</button></a></div>
    <div><button>Rapporter skade</button></div>
    <div>Du leverte dette verktøyet: 2021-11-11 00:00:00.0</div>
</li><br>

    <li class="bookingLi" style="">
    <br><div><b>9` vinkelsliper 230VAC</b></div>
    <div> start: 2021-11-26</div>
    <div> slutt: 2021-11-27</div>
    <br><div>Du skylder 20 kr for denne bookingen <br><a href="markBookingPaidServlet?booking_id=8"><button class="paymentButton">Betal nå med vipps</button></a></div>
    <div><button>Rapporter skade</button></div>
    <div><a href="markToolDeliveredServlet?booking_id=8&amp;tool_id=5"><button>Marker som levert</button></a></div>
</li><br>

    <li class="bookingLi ubetalt ulevert" style="">
    <br><div><b>Diagnoseringsverktøy, bil</b></div>
    <div> start: 2021-11-26</div>
    <div> slutt: 2021-11-27</div>
    <br><div>Du skylder 50 kr for denne bookingen <br><a href="markBookingPaidServlet?booking_id=9"><button class="paymentButton">Betal nå med vipps</button></a></div>
    <div><button>Rapporter skade</button></div>
    <div><a href="markToolDeliveredServlet?booking_id=9&amp;tool_id=10"><button>Marker som levert</button></a></div>
</li><br>

    <li class="bookingLi ulevert" style="">
    <br><div><b>Eksentersliper 230VAC</b></div>
    <div> start: 2021-11-17</div>
    <div> slutt: 2021-11-18</div>
    <br><div>Du skylder 80 kr for denne bookingen <br><a href="markBookingPaidServlet?booking_id=16"><button class="paymentButton">Betal nå med vipps</button></a></div>
    <div><button>Rapporter skade</button></div>
    <div><a href="markToolDeliveredServlet?booking_id=16&amp;tool_id=1"><button>Marker som levert</button></a></div>
</li><br></ul>

<a href="SiteAdmin/Admin_dashboard.jsp"><button>Gå til admin dashboard</button></a>



<script>

    currentDate = new Date();
    currentDate.setHours(0,0,0,0);

    dateinput = document.getElementById("dateInput");

    dateinput.oninput = function (){
        let inputDate = new Date(dateinput.value);
        if(inputDate < currentDate){
            alert("Denne datoen har passert");
            dateinput.value = null;
        }
    }

    function alertDateIsPast(){
        alert("Denne datoen har allerede passert");
    }


    input1.oninput = function checkDate(){
        var GivenDate = input1.value;
        var CurrentDate = new Date();
        GivenDate = new Date(GivenDate);
        CurrentDate.setHours(0,0,0,0);
        if(input2.value!=null){
            var endDate = input2.value;
            endDate = new Date(endDate);
            if(endDate<GivenDate){
                alert("Startdato kan ikke være etter sluttdato");
                input1.value = null;
            }
        }
        if(input1.value < currentDate){
            alert("Denne datoen har passert");
            input1.value = null;
        }
        for (let i = 0; i < busyDates.length; i++) {
            if (input1.value == busyDates[i]) {
                alertOverlappingBookings();
            }
        }
        if (input2.value != "") {
            checkDatesBetween(selectedDate, dateEndInput.value);
        }
    }

</script>





</body>

</html>
