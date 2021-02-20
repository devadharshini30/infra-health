const express = require('express')
const path = require('path')
const app = express()
const router = express.Router();
const port = 3000

router.get('/dash', (req, res) => {
    res.sendFile('index.html')
})

app.use('/', router);

app.listen(port, () => {
  console.log(`Example app listening at http://localhost:${port}`)
})