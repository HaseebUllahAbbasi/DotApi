const express = require('express') 
const app = new express()
const cors = require('cors')
app.use(express.json())

const personRoutes = require('./Routers/PersonRoutes')

app.use(cors())
app.use(personRoutes)

module.exports = app;