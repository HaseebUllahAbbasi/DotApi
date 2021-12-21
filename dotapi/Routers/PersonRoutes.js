const express = require('express');
const { addPerson, getAllPersons,findPersonById,updatePerson,findPersonByName ,findPersonByCity, deletePerson} = require('../controllers/PersonController');
const router = express.Router();
router.route('/person').post(addPerson);
router.route('/person').get(getAllPersons);
router.route('/person').put(updatePerson);
router.route('/person/:name').delete(deletePerson);
router.route('/personByName/:name').get(findPersonByName);
router.route('/person/:id').get(findPersonById);
router.route('/personByCity/:city').get(findPersonByCity);

module.exports = router;



//heroku login
//heroku create
//git push heroku main


// generated from heroku
 // https://protected-inlet-55078.herokuapp.com/

// https://protected-inlet-55078.herokuapp.com/person 
