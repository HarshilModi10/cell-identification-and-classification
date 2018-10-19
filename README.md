# cell-identification-and-classification

I utilized QuPath (0.1.2) (https://qupath.github.io) an open-source Digital Image Analysis (DIA) platform to analyze double and triple positive immunofluorescence stained mouse brain specimen collected on the Superfrost Plus slides. All the image analysis was performed using “.tif” formatted files. Rectangular tool selections were used to identify the area in the image for counting the subjects (cells). Classification of each cell was done based on cell morphology (pixel area, background radius, gaussian filtration, threshold intensity, and background intensity).

The characteristics that were used to define a cell type for E12.5 and E15.5 were: background radius of 15 px, median filter radius of 0 px, sigma of 3 px, minimum area of 50 px2, maximum area of 1000 px2, intensity threshold of 15 for DAPI and 20 - 30 for Red and Green channel cells, and cell expansion of 5 px.

The software was used to count double positive cells of (DAPI/Tbr1, DAPI/Tbr2, DAPI/Phh3 in a loss of function analysis) and for triple staining we analyzed the biomarkers of (DAPI/GFP/Tbr1 and DAPI/GFP/Brdu). DAPI (blue) is was used as the counter stain. Statistical analysis of all the counts were performed using GraphPad Prism 8 statistical software. The detailed protocol to use Qupath for cell counting:
1.	System requirements: A minimum of 64-bit processor & operating system 4 GB RAM (for browsing images, limited analysis), 500 MB hard disk space, For Mac, at least OS X 10.7.4
2.	Format: Image format for analysis “.tif”
3.	Installation: Download QuPath from the link provided based on your operating system. Next install the software onto your computer using the QuPath application and open it. https://qupath.github.io/
4.	Click ‘file’ then ‘open’, or (Ctrl + O) and select the “.tif” file to count
5.	Classifying objects: Create an annotation around the region of interest using either the rectangle, circle, or polygon tool from the toolbar on the top left of the screen. 
6.	Automation Detection: Next click ‘Automate’ followed by clicking to ‘Show script editor’ and a new window will pop up.
7.	Open up an existing “. groovy” file or create a script of your own for analysis.
8.	Annotation: Click ‘run’ for the toolbar then ‘run’ again. You will notice that cells will be highlighted on the picture.
9.	Select ‘annotation’ from the toolbar and the count data will be provided in the bottom left table 

ONLY SAMPLE DATA/SCRIPTS WERE PROVIDED FOR SECURITY REASONS.

## Original: Tbr1, GFP, Dapi stainning 1002
![triple postive 1001](sample_data/Original%20Pictures/1001A.png)

## Proccessed: Tbr1, GFP, Dapi stainning 1002
![triple postive 1001](sample_data/Processed%20Pictures/1002A.png)
