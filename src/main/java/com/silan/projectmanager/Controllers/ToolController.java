package com.silan.projectmanager.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.silan.projectmanager.Model.Tool;
import com.silan.projectmanager.Services.ToolService;

import java.util.List;
import java.util.Optional;

@RestController
public class ToolController {
  @Autowired
  private ToolService toolService;

  @GetMapping(value = "/api/get-tools")
  public List<Tool> getAllTools() {
    return toolService.getAllTools();
  }

  @GetMapping(value = "/api/get-tool/{id}")
  public Optional<Tool> getToolById(@PathVariable("id") String id) {
    return toolService.getToolById(id);
  }

  @CrossOrigin(origins = "http://localhost:4200")
  @PostMapping(value = "/api/create-tool")
  public ResponseEntity<Tool> createTool(@RequestBody Tool tool) {
    Tool savedTool = toolService.createTool(tool);
    return ResponseEntity.ok(savedTool);
  }

  @CrossOrigin(origins = "http://localhost:4200")
  @PutMapping(value = "/api/update-tool/{id}")
  public ResponseEntity<Tool> updateTool(@PathVariable("id") String id, @RequestBody Tool tools) {
    Tool updatedTool = toolService.updateTool(id, tools);
    return ResponseEntity.ok(updatedTool);
  }

  @DeleteMapping(value = "/api/del-tool/{id}")
  public ResponseEntity<String> deleteTool(@PathVariable("id") String id) {
    toolService.deleteTool(id);
    return ResponseEntity.ok("Tool deleted");
  }

}
