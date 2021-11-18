
<html>
<head>
    <title>book verktøy</title>
    <link href="styles.css" rel="stylesheet" type="text/css">
    <meta charset="UTF-8"></head>

<body>
<br>


<div class="container">

    <div class="calendar">

        <header>

            <h2 id="headerMonth"></h2>

            <button class="btn-prev fontawesome-angle-left" id="btn-prev">forrige måned</button>
            <button class="btn-next fontawesome-angle-right" id="btn-next">neste måned</button>

        </header>

        <table id="calendarTable">
            <thead>
            <tr>
                <td>*</td>
                <td>*</td>
                <td>*</td>
                <td>*</td>
                <td>*</td>
                <td>*</td>
                <td>*</td>
            </tr>
            </thead>

            <tbody>
            <tr>
                <td class="date">*</td>
                <td class="date">*</td>
                <td class="date">*</td>

                <td class="date">*</td>
                <td class="date">*</td>
                <td class="date">*</td>
                <td class="date">*</td>
            </tr>
            <tr>
                <td class="date">*</td>
                <td class="date">*</td>
                <td class="date">*</td>
                <td class="date">*</td>
                <td class="date">*</td>
                <td class="date">*</td>
                <td class="date">*</td>
            </tr>
            <tr>
                <td class="date">*</td>
                <td class="date">*</td>
                <td class="date">*</td>
                <td class="date">*</td>
                <td class="date">*</td>
                <td class="date">*</td>
                <td class="date">*</td>
            </tr>
            <tr>
                <td class="date">*</td>
                <td class="date">*</td>
                <td class="date">*</td>
                <td class="date">*</td>
                <td class="date">*</td>
                <td class="date">*</td>
                <td class="date">*</td>
            </tr>
            <tr>
                <td class="date">*</td>
                <td class="date">*</td>
                <td class="date">*</td>
                <td class="date">*</td>
                <td class="date">*</td>
                <td class="date">*</td>
                <td class="date">*</td>
            </tr>
            </tbody>
        </table>
    </div>
</div><h2>book dette verktøyet</h2><form action="SiteUser/BookingServlet" method="post">

    <input type="hidden" name="Tool_id" value = '1'> <br/>

    <input type="hidden" name="User_id" value = '1'> <br/>

    <label>Startdato</label>
    <input type="date" name="Booking_dateStart" id="dateStartInput" required> <br/> <br/>

    <label>sluttdato</label>
    <input type="date" name="Booking_dateEnd" id="deteEndInput" required> <br/> <br/>

    <label>Booking paid:</label> <br/>
    <label>Ja</label>
    <input type="radio" name="Booking_paid" value="true"> <br/>
    <label>Nei</label>
    <input type="radio" name="Booking_paid" value="false" checked> <br/>


    <a href="home.jsp"><button type="submit" value="Register" onclick="showMessage()">Registrer</button> <br/></a>
</form><script>
    var input1 = document.getElementById("dateStartInput");
    var input2 = document.getElementById("dateEndInput")

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
        if(GivenDate < CurrentDate){
            alert("Denne datoen har passert");
            input1.value = null;
        }
        for (let i = 0; i < busyDates.length; i++) {
            if (selectedDate == busyDates[i]) {
                alertOverlappingBookings();
            }
        }
        if (dateEndInput.value != "") {
            checkDatesBetween(selectedDate, dateEndInput.value);
        }
    }
    input2.oninput = function checkOverLappingDate(){
        var startDate = input1.value;
        var endDate = input2.value;
        startDate = new Date(startDate);
        endDate = new Date(endDate);
        if (endDate < startDate){
            alert("Sluttdato må være samme dato som, eller etter startdatoen");
            input2.value = null;
        }
        for (let i = 0; i < busyDates.length; i++) {
            if (selectedEndDate == busyDates[i]) {
                alertOverlappingBookings();
            }
        }
        if(dateStartInput.value != ""){
            checkDatesBetween(dateStartInput.value, endDate);
        }    }
    headerMonth = document.getElementById("headerMonth");
    let selectedMonth = new Date();

    let nameOfMonthNO = selectedMonth.toLocaleString(
        'no-NO', {month: 'long'}
    );

    weekDays = ['man', 'tir', 'ons', 'tor', 'fre', 'lør', 'søn'];
    busyDates =["2021-11-20", "2021-11-21", "2021-11-22", "2021-11-23", "2021-11-24"]
    console.log(busyDates);
    headerMonth.innerHTML = nameOfMonthNO;
    loadDates();

    function getFirstDate(){
        var firstDay = new Date(selectedMonth.getFullYear(), selectedMonth.getMonth(), 1);
        return firstDay;
    }

    function getDayName(dateStr)
    {
        var date = new Date(dateStr);
        return date.toLocaleDateString('en-EN', { weekday: 'long' });
    }

    function initWeekDays(){
        weekDays = ['man', 'tir', 'ons', 'tor', 'fre', 'lør', 'søn'];
    }

    function sortWeekDays(){
        initWeekDays()
        var day = getDayName(getFirstDate(selectedMonth.toString()));
        if(day == 'Monday'){
        }
        else if(day =='Tuesday'){
            pushArray(pushArray(1));
        }
        else if (day =='Wednesday'){
            pushArray(2);

        }
        else if (day == 'Tuesday'){
            pushArray(3)
        }
        else if (day == "Friday"){
            pushArray(4);
        }
        else if (day == "Saturday"){
            pushArray(5);

        }
        else if (day == "Sunday"){
            pushArray(6);
        }
    }

    function pushArray(times){
        for(var i = 0; i < times; i++){
            weekDays.push(weekDays.shift());
        }
    }

    function daysInMonth (month, year) {
        date = new Date(year, month+1, 0);
        return date.getDate();
    }

    function loadDates(){
        var maxDays = daysInMonth(selectedMonth.getMonth(), selectedMonth.getFullYear());
        var counter = 1;
        var counter2 = 1;
        var table = document.getElementById("calendarTable");
        for (var i = 0, row; row = table.rows[i]; i++) {

            for (var j = 0, col; col = row.cells[j]; j++) {
                col.classList.remove("next-month");            if(i==0){
                    col.innerHTML = weekDays[j];

                }
                else{
                    if (counter <= maxDays) {
                        col.innerHTML = counter;
                        col.classList.remove("current-day")
                        for(let k = 0; k <busyDates.length; k++){
                            var datenew = new Date(busyDates[k]);
                            if(selectedMonth.getMonth() == datenew.getMonth() && datenew.getDate()==counter){
                                col.classList.toggle("current-day")                           }
                        }                    counter++;
                    }
                    else{
                        col.classList.toggle("next-month")
                        col.innerHTML = counter2;
                        counter2++;
                    }
                }
            }
        }
    }
    function checkDatesBetween(startDate, endDate){
        let datesBetween = getDatesBetween(startDate, endDate);

        for (let i = 0; i < datesBetween.length; i++) {
            if (busyDates.includes(datesBetween[i].toISOString().split('T')[0])){
                alertOverlappingBookings();
                return;
            }
        }
    }

    function alertOverlappingBookings(){
        alert("Du har valgt en booking som strider med andre bookinger.\nVennligst velg andre datoer.");
        dateStartInput.value = null;
        dateEndInput.value = null;
    }

    function getDatesBetween(startDate, endDate){
        let currentDay = new Date(startDate);
        endDate = new Date(endDate);

        let datesBetween = [];

        while(currentDay <= endDate){
            datesBetween.push(currentDay);
            currentDay = currentDay.addDays(1);
        }
        return datesBetween;

    }

    Date.prototype.addDays = function(days) {
        let date = new Date(this.valueOf());
        date.setDate(date.getDate() + days);
        return date;
    }
    document.getElementById("btn-next").onclick = function (){
        let nextMonth = new Date(selectedMonth);
        nextMonth.setMonth(selectedMonth.getMonth() + 1);
        selectedMonth = nextMonth;
        let nameOfMonthNO = selectedMonth.toLocaleString(
            'no-NO', {month: 'long'}
        );
        headerMonth.innerHTML = nameOfMonthNO;
        sortWeekDays();
        loadDates();
    }

    document.getElementById("btn-prev").onclick = function (){
        let nextMonth = new Date(selectedMonth);
        nextMonth.setMonth(selectedMonth.getMonth() - 1);
        selectedMonth = nextMonth;
        let nameOfMonthNO = selectedMonth.toLocaleString(
            'no-NO', {month: 'long'}
        );
        headerMonth.innerHTML = nameOfMonthNO;
        sortWeekDays();
        loadDates();
    }</script></body>
</html>
