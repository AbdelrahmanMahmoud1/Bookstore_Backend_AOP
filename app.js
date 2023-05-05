const _ = require('lodash')

const items = [1,[2,[3,[4]]]]
const newItem= _.flatMapDeep(items)
console.log(newItem);