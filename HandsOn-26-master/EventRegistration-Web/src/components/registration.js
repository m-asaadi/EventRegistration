import axios from 'axios'
var config = require('../../config')

var frontendUrl = 'http://' + config.dev.host + ':' + config.dev.port
var backendUrl = 'http://' + config.dev.backendHost + ':' + config.dev.backendPort

var AXIOS = axios.create({
  baseURL: backendUrl,
  headers: { 'Access-Control-Allow-Origin': frontendUrl }
})

function ParticipantDto (name) {
  this.name = name
  this.events = []
}

function EventDto (name, date, start, end) {
  this.name = name
  this.eventDate = date
  this.startTime = start
  this.endTime = end
}

export default {
  name: 'eventregistration',
  data () {
    return {
      participants: [],
      events: [],
      newParticipant: '',
      errorParticipant: '',
      response: [],
      newEvent: {
        name: '',
        date: '',
        startTime: '',
        endTime: '' },
      errorEvent: '',
      response2: []
    }
  },
  // ...

  created: function () {
// Initializing participants from backend
    AXIOS.get(`/participants`)
    .then(response => {
      // JSON responses are automatically parsed.
      this.participants = response.data
    })
    .catch(e => {
      this.errorParticipant = e
    })
    console.log('Participants listed')
  // Initializing events from backend
    AXIOS.get('/events/')
    .then(response => {
      // JSON responses are automatically parsed.
      this.events = response.data
    })
    .catch(e1 => {
      this.errorEvent = e1
    })
    console.log('Events listed')
  },
  methods: {
    createParticipant: function (participantName) {
      AXIOS.post('/participants/' + participantName, {}, {})
  .then(response => {
    // JSON responses are automatically parsed.
    this.participants.push(response.data)
    this.newParticipant = ''
    this.errorParticipant = ''
  })
  .catch(e => {
    var errorMsg = e.response.data.message
    console.log(errorMsg)
    this.errorParticipant = errorMsg
  })
    },
    createEvent: function (eventName, eventDate, startTime, endTime) {
      AXIOS.post('/events/'.concat(eventName), {}, {
        params: {
          date: eventDate,
          startTime: startTime,
          endTime: endTime }}
         ).then(response => {
    // JSON responses are automatically parsed.
           this.events.push(response.data)
           this.newEvent = ''
           this.newEvent.name = ''
           this.newEvent.date = ''
           this.newEvent.startTime = ''
           this.newEvent.endTime = ''
           this.errorEvent = ''
         })
  .catch(e1 => {
    var errorMsg = e1.response.data.message
    console.log(errorMsg)
    this.errorEvent = errorMsg
  })
    },
    registerEvent: function (participantName, eventName) {
      var indexEv = this.events.map(x => x.name).indexOf(eventName)
      var indexPart = this.participants.map(x => x.name).indexOf(participantName)
      var participant = this.participants[indexPart]
      var event = this.events[indexEv]
    // var nReg = new RegisterDto( participant, event)
      AXIOS.post('/register/', {}, {
        params: {
          participant: participant.name,
          event: event.name }}
        ).then(response => {
    // JSON responses are automatically parsed.
          participant.events.push(event)
          this.selectedParticipant = ''
          this.selectedEvent = ''
        })
  .catch(e => {
    var errorMsg = e.response.data.message
    console.log(errorMsg)
    this.errorEvent = errorMsg
  })
    }
  }
}

