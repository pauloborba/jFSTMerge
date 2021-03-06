package br.ufpe.cin.mergers.util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.tuple.Pair;

import de.ovgu.cide.fstgen.ast.FSTNode;

/**
 * Encapsulates pertinent information of the merging process. A context
 * is necessary to handle specific conflicts that simple
 * superimposition of trees is not able to address. 
 * @author Guilherme
 */
public class MergeContext {
	File base;
	File right;
	File left;
	String outputFilePath;
	
	public List<FSTNode> addedLeftNodes = new ArrayList<FSTNode>();
	public List<FSTNode> addedRightNodes= new ArrayList<FSTNode>();
	
	public List<FSTNode> deletedBaseNodes = new ArrayList<FSTNode>();
	public List<Pair<String,FSTNode>> deletedLeftNodes = new ArrayList<Pair<String,FSTNode>>();
	public List<Pair<String,FSTNode>> deletedRightNodes= new ArrayList<Pair<String,FSTNode>>();


	public List<FSTNode> editedLeftNodes = new ArrayList<FSTNode>(); 
	public List<FSTNode> editedRightNodes= new ArrayList<FSTNode>();
	

	public FSTNode superImposedTree;
	public String semistructuredOutput;
	public String unstructuredOutput;
	
	public int newElementReferencingEditedOneConflicts = 0;
	public int renamingConflicts = 0;
	public int typeAmbiguityErrorsConflicts = 0;
	public int deletionConflicts = 0;
	
	public MergeContext(){
	}

	public MergeContext(File left, File base, File right, String outputFilePath) {
		this.left = left;
		this.base = base;
		this.right= right;
		this.outputFilePath = outputFilePath;
	}

	/**
	 * Joins the information of another context.
	 * @param otherContext the context to be joined with
	 */
	public MergeContext join(MergeContext otherContext){
		this.addedLeftNodes. addAll(otherContext.addedLeftNodes);
		this.addedRightNodes.addAll(otherContext.addedRightNodes);
		
		this.editedLeftNodes. addAll(otherContext.editedLeftNodes);
		this.editedRightNodes.addAll(otherContext.editedRightNodes);
		
		this.deletedBaseNodes. addAll(otherContext.deletedBaseNodes);
		this.deletedLeftNodes. addAll(otherContext.deletedLeftNodes);
		this.deletedRightNodes.addAll(otherContext.deletedRightNodes);

		this.superImposedTree = otherContext.superImposedTree;
		this.renamingConflicts+=otherContext.renamingConflicts;
		this.newElementReferencingEditedOneConflicts+=otherContext.newElementReferencingEditedOneConflicts;
		this.typeAmbiguityErrorsConflicts+=otherContext.typeAmbiguityErrorsConflicts;
		this.deletionConflicts+=otherContext.deletionConflicts;
		
		return this;
	}
	
	public File getBase() {
		return base;
	}

	public void setBase(File base) {
		this.base = base;
	}

	public File getRight() {
		return right;
	}

	public void setRight(File right) {
		this.right = right;
	}

	public File getLeft() {
		return left;
	}

	public void setLeft(File left) {
		this.left = left;
	}
}
