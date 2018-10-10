setImageType('FLUORESCENCE');
runPlugin('qupath.imagej.detect.nuclei.WatershedCellDetection', '{"detectionImageFluorescence": 1,  "backgroundRadius": 30.0,  "medianRadius": 0.0,  "sigma": 3.0,  "minArea": 50.0,  "maxArea": 1000.0,  "threshold": 20.0,  "watershedPostProcess": true,  "cellExpansion": 5.0,  "includeNuclei": true,  "smoothBoundaries": true,  "makeMeasurements": true}');


// setting up different channels
channel_2 = 'Nucleus: Channel 2 mean'

// setting channel threshold values

thresholdChannel_2 = 25

// initializing Colour schemes
 red = getColorRGB(150,0,0)
 green = getColorRGB(0,150,0)
 yellow = getColorRGB(255,255,0)
 blue = getColorRGB(0,0,150)
 
// initializing/creating cell detection classifiers
doubleChannelPositive = getPathClass('Double positive', yellow)
channel_1Positive = getPathClass('channel_1', red)

//creates a list of all cells detected
cellsDetected = getCellObjects()

// This loop runs through all the cells detected and classifies them
for (cell in cellsDetected){

    // acquire the channel one and channel two intensities for each cell

    channel_2_Intensity = measurement(cell, channel_2)

    // checks if the acquired intensity for channel 1 is higher then the threshold intensity        
    if (channel_2_Intensity> thresholdChannel_2){
        cell.setPathClass(doubleChannelPositive)
    }    
    else{
       //else classifies the cell as channel 3 positive
       cell.setPathClass(channel_1Positive)
   } 
} 
  
fireHierarchyUpdate() 
