const express = require('express')
const path = require('path')

const root = path.join(__dirname, 'public')
const front = path.join(root, 'index.html')
const port = process.env.PORT || 8787

const app = express()
  .use(express.static(root))
  .get('*', (req, res) => res.sendFile(front))
  .listen(port)

if (process.env.NODE_ENV !== 'production') {
  console.log(`Server started on port ${port}`)
}
