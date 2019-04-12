<template>

<div id="eventregistration">

    <h2>Event Registration</h2> 
    <table style="width:100%">
 <th>Participants</th>
    <th>Event Participation</th>
<tr v-for="participant in participants" >
      <td>{{ participant.name }}</td>
      <td>
        <ul>
          <li v-for="event in participant.events">
            {{event.name}}
          </li>
        </ul>
      </td>
  </tr>
      <tr>
          <td>John</td>
          <td>Event to attend</td>
      </tr>
</table>
<p></p>


<table id="t01">
      <tr>
          <td>
              <input type="text" v-model="newEvent.name" placeholder="Event Name">
              <tr>
   <input type="date" v-model="newEvent.date" placeholder="YYYY-MM-DD">
              <input type="time" v-model="newEvent.startTime" placeholder="HH:mm">
              <input type="time" v-model="newEvent.endTime" placeholder="HH:mm">
 </tr>
          </td>
          <td>
              <button @click="createEvent(newEvent.name, newEvent.date, newEvent.startTime, newEvent.endTime)">Create Event</button>

          </td>
      </tr>
 
 <tr>
    <td>
        <input type="text" v-model="newParticipant" placeholder="Participant Name">
    </td>
    <td>
        <button @click="createParticipant(newParticipant)">Create Participant</button>
    </td>
  </tr>

    </table>
    <p>
      <span v-if="errorParticipant" style="color:red">Error: {{errorParticipant}} </span>
      <span v-if="errorEvent" style="color:red">Error: {{errorEvent}} </span>

    </p>
       <h3 style="font-size:25px;">Events</h3>
<ul>
<li v-for="event in events">
{{event.name}}
</li>
</ul>

 <h4 style="font-size:25px;">Registration</h4>
 <select v-model="selectedParticipant">
 <option disabled value="">Please select one</option>
 <option v-for="participant in participants" >
     {{ participant.name }}
 </option>
</select>
<select v-model="selectedEvent">
 <option disabled value="">Please select one</option>
 <option v-for="event in events" >
     {{ event.name }}
 </option>
</select>
<button id ="register" :disabled="selectedParticipant=='' || selectedEvent==''"@click="registerEvent(selectedParticipant, selectedEvent)">Register</button>
  </div>
</template>
<script src="./registration.js">
</script>
<style>
table, th, td{
    border: 1px solid black;
 border-collapse: collapse;
}
 #eventregistration {
    font-family: 'Avenir', Helvetica, Arial, sans-serif;
    color: #2c3e50;
    background: #D3D3D3;
  }
th, td {
    padding: 5px;
}

table#t01 {
    width: 100%;    
   border: 1px solid black;
}
</style>
