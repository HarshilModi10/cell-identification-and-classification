"""
Title: Qupath Immunofluorescence Automatic Cell Counting Software

Lab: 118A
PI: Dr. Carol Schuurmans
Creator: Harshil Modi  

Description:
This software uses different colour intensities based on the RGB colour scheme to categorize and count double and triple positive cells.
"""

// select the channel you want to detect cells (e.g. Dapi channel)
// set background radius higher then the radius of the largest cell
// minArea is the minimum area of the cells you want to detect in px^2 (pixels)
// MaxArea is the maximum area of the cells you want to detect in px^2 (pixels)
// threshold is the minimun threshold intensity of the detected cell for the channel selected
setImageType('FLUORESCENCE');
runPlugin('qupath.imagej.detect.nuclei.WatershedCellDetection', '{"detectionImageFluorescence": 3,  "backgroundRadius": 30.0,  "medianRadius": 0.0,  "sigma": 3.0,  "minArea": 50.0,  "maxArea": 1000.0,  "threshold": 15.0,  "watershedPostProcess": true,  "cellExpansion": 5.0,  "includeNuclei": true,  "smoothBoundaries": true,  "makeMeasurements": true}');


// setting up different channels
channel_1 = 'Nucleus: Channel 1 mean'
channel_2 = 'Nucleus: Channel 2 mean'

// setting channel threshold values
thresholdChannel_1 = 20
thresholdChannel_2 = 30

// initializing Colour schemes
 red = getColorRGB(150,0,0)
 green = getColorRGB(0,150,0)
 yellow = getColorRGB(255,255,0)
 blue = getColorRGB(0,0,150)
 
// initializing/creating cell detection classifiers
doubleChannelPositive = getPathClass('Double positive', yellow)
channel_1Positive = getPathClass('channel_1', red)
channel_2Positive = getPathClass('channel_2', green)
channel_3Positive = getPathClass('channel_3',blue)

//creates a list of all cells detected
cellsDetected = getCellObjects()

// This loop runs through all the cells detected and classifies them
for (cell in cellsDetected){

    // acquire the channel one and channel two intensities for each cell
    channel_1_Intensity = measurement(cell, channel_1)
    channel_2_Intensity = measurement(cell, channel_2)

    // checks if the acquired intensity for channel 1 is higher then the threshold intensity        
    if (channel_1_Intensity> thresholdChannel_1){
        
        // checks if the aquired intensity for channel two is higher then the threshold intensity
        if (channel_2_Intensity >thresholdChannel_2){
            // if both condition is true, classifies cell as double positive
            cell.setPathClass(doubleChannelPositive)
        }
        else{
            // if only the first condition is true, classifies the cell as channel 1 positive
            cell.setPathClass(channel_1Positive)
        }
   }
   
   else if (channel_2_Intensity> thresholdChannel_2){
       // classifies the cell as channel 2 positive
       cell.setPathClass(channel_2Positive)
   }
   else{
       //else classifies the cell as channel 3 positive
       cell.setPathClass(channel_3Positive)
   } 
} 
  
fireHierarchyUpdate() 
