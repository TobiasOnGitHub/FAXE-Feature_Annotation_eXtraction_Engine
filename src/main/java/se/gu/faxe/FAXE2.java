package se.gu.faxe;

import com.scalified.tree.TreeNode;
import com.scalified.tree.multinode.ArrayMultiTreeNode;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class FAXE2 {

    private TreeNode<Asset> knownAssets;
    private FeatureModel featureModel = null;

    public FAXE2 (File rootDirectory){
        if(rootDirectory==null){
            throw new IllegalArgumentException("FAXE2::FAXE2 Given rootDirectory equals NULL!");
        }

        if(!rootDirectory.exists()){
            throw new IllegalArgumentException("FAXE2::FAXE2 Given rootDirectory does NOT exist!");
        }

        if(!rootDirectory.isDirectory()){
            throw new IllegalArgumentException("FAXE2::FAXE2 Given rootDirectory NOT!");
        }

        /*****************************************************************************************/
        /** ANALYSIS OF FEATURE HIERARCHY as *.feature-model, feature-model or *.cfr or . file **/
        /****************************************************************************************/
         Supplier<Stream<Path>> streamSupplier = () -> {
             try {
                 return Files.walk(Paths.get(rootDirectory.getPath()));
             } catch (IOException e) {
                 e.printStackTrace();
                 return null;
             }
        };
        String pathFM = streamSupplier.get().map(x -> x.toString()).filter(f -> f.endsWith(".feature-model") || f.endsWith(".cfr") || f.equals("feature-model")).findFirst().get();
        featureModel = new FeatureModel(new File(pathFM));

        /***********************************************************************/
        /** GO THROUGH ALL ASSETS, CREATE ASSET TREE AND FILL ANNOTATION DATA **/
        /***********************************************************************/
        // Add root node
        Asset as = new Asset(rootDirectory);
        knownAssets = new ArrayMultiTreeNode<>(as);

        for (File file : rootDirectory.listFiles()) {
            Asset nextAsset = new Asset(file);

            if (file.isDirectory()) {
                System.out.println("Directory: " + file.getName());
                //showFiles(file.listFiles()); // Calls same method again.
                // TODO - Go recursive through folders
            } else {
                System.out.println("File: " + file.getName());
                // TODO - extract data via Grammar and link it
            }

            /*****************************/
            /**  ADD TO ASSET-TREE **/
            /*****************************/
            File parent = file.getParentFile();
            TreeNode<Asset> nodeParent = knownAssets.find(new Asset(parent));
            nodeParent.add(new ArrayMultiTreeNode<>(nextAsset));
        }

        System.out.println(knownAssets);


        /***********************************/
        /** ANALYSIS OF FEATURE-TO-FOLDER **/
        /***********************************/



        System.out.println("c");
    }


}
