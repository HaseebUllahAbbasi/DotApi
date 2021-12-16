const PersonSchema = require('../model/Person')
const catchAsyncErrors = require('../middlewares/catchAsyncError');

exports.getAllPersons = catchAsyncErrors(async (req, res, next) => {
  const   allPersons = await PersonSchema.find(); 
  if(allPersons.length ==0)
  {
    res.status(200).json(
        {
            success: false,
            message : "No Persons"
        }
    )  
  }
  else
  res.status(200).json(
      {
          success: true,
          persons: allPersons
      }
  )
})

exports.deletePerson = catchAsyncErrors(async (req, res, next) => {
    const {id} =  req.body;
    const updatedPerson  = await PersonSchema.findByIdAndDelete({_id:id})  
    res.status(200).json({
        updatedPerson: true,
    })
}
)
exports.updatePerson = catchAsyncErrors(async (req, res, next) => {
    const {id,name,email,number} =  req.body;
    const updatedPerson   = await PersonSchema.findByIdAndUpdate({_id:id},{
    })  
    res.status(200).json({
        updatedPerson: true,
    })
})
exports.addPerson = catchAsyncErrors(async (req, res, next) => {
    const { name, email, number, password } = req.body;
    const personCreated = await PersonSchema.create({
        name, password, email, number
    });
    res.status(200).json({
        success: true,
        personCreated
    })
})
